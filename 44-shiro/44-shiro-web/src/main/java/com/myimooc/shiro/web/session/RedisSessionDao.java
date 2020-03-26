package com.myimooc.shiro.web.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 使用redis管理session；重写session管理的方法
 *
 * @author zc 2018-05-03
 */
public class RedisSessionDao extends AbstractSessionDAO {

    private final String SHIRO_SESSION_PREFIX = "shiro-session:";

    @Autowired
    private RedisTemplate redisTemplate;

    private byte[] getKey(String key) {
        return (SHIRO_SESSION_PREFIX + key).getBytes();
    }

    private void saveSession(Session session) {
        if (session != null && session.getId() != null) {
            Serializable sessionId = generateSessionId(session);
            byte[] key = getKey(session.getId().toString());
            byte[] value = SerializationUtils.serialize(session);
            redisTemplate.opsForValue().set(key, value, 600, TimeUnit.SECONDS);
        }
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        System.out.println("读取session");
        if (sessionId == null) {
            return null;
        }
        byte[] key = getKey(sessionId.toString());
        byte[] value = (byte[]) redisTemplate.opsForValue().get(key);
        return (Session) SerializationUtils.deserialize(value);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        saveSession(session);
    }

    @Override
    public void delete(Session session) {
        if (session == null || session.getId() == null) {
            return;
        }
        byte[] key = getKey(session.getId().toString());
        redisTemplate.opsForValue().getOperations().delete(key);
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<byte[]> keys = redisTemplate.opsForValue().getOperations().keys(SHIRO_SESSION_PREFIX + "*");
        Set<Session> sessions = new HashSet<>();
        if (CollectionUtils.isEmpty(keys)) {
            return sessions;
        }
        for (byte[] key : keys) {
            byte[] value = (byte[]) redisTemplate.opsForValue().get(key);
            sessions.add((Session) SerializationUtils.deserialize(value));
        }
        return sessions;
    }
}
