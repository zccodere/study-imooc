package com.myimooc.java.sms.file;


import com.myimooc.java.sms.model.BaseEntity;
import com.myimooc.java.sms.persistence.PersistenceException;
import com.myimooc.java.sms.persistence.PersistenceService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 持久化到文件
 *
 * @author zc
 * @date 2018/05/29
 */
public class PersistenceServiceImpl implements PersistenceService {

    private final Path dataPath = Paths.get(".", "data");

    @Override
    public <T extends BaseEntity> List<T> list(Class<T> type) throws PersistenceException {
        List<T> results = new ArrayList<>(16);
        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(getEntityPath(type, "*.bin"));
            for (Path path : directoryStream) {
                results.add(readEntity(path));
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenceException(e);
        }
        return results;
    }

    @Override
    public <T extends BaseEntity> T getOne(Class<T> type, String id) throws PersistenceException {
        try {
            return readEntity(getEntityPath(type, id));
        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void save(BaseEntity entity) throws PersistenceException {
        try {
            this.saveEntity(entity);
        } catch (IOException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public <T extends BaseEntity> void remove(Class<T> type, String id) throws PersistenceException {
        try {
            this.readEntity(getEntityPath(type, id));
        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenceException(e);
        }
    }

    private Path getEntitiesPath(Class<?> type) {
        return dataPath.resolve(type.getSimpleName());
    }

    private Path getEntityPath(Class<?> type, String id) {
        return getEntitiesPath(type).resolve(String.format("%s.bin", id));
    }

    private <T extends BaseEntity> T readEntity(Path path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path));
        return (T) objectInputStream.readObject();
    }

    private void saveEntity(BaseEntity entity) throws IOException {
        Path path = getEntityPath(entity.getClass(), entity.getId());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path));
        objectOutputStream.writeObject(entity);
    }

    private void removeEntity(Class<? extends BaseEntity> type, String id) throws IOException {
        Files.deleteIfExists(getEntityPath(type, id));
    }
}
