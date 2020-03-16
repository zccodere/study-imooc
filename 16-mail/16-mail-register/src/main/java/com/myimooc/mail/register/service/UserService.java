package com.myimooc.mail.register.service;

import com.myimooc.mail.register.dao.UserRepository;
import com.myimooc.mail.register.domain.User;
import com.myimooc.mail.register.enums.UserStateEnum;
import com.myimooc.mail.register.util.MailUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 用户服务层
 *
 * @author zc 2017-06-07
 */
@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    /**
     * 用户注册的方法
     */
    public void register(User user) {
        // 将数据存入到数据库
        userRepository.save(user);

        // 发送一封激活邮件
        try {
            MailUtils.sendMail(user.getEmail(), user.getCode());
        } catch (Exception ex) {
            logger.warn("邮件发送异常：", ex);
        }
    }

    /**
     * 用户激活的方法
     */
    public boolean registerActive(String code) {
        User user = userRepository.findByCode(code);
        if (Objects.isNull(user)) {
            return false;
        }

        user.setState(UserStateEnum.ACTIVATED.getValue());
        user.setCode("");
        userRepository.save(user);
        return true;
    }
}
