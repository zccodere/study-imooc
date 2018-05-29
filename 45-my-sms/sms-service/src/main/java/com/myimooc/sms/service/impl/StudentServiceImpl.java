package com.myimooc.sms.service.impl;

import com.myimooc.sms.model.Student;
import com.myimooc.sms.persistence.PersistenceException;
import com.myimooc.sms.persistence.PersistenceService;
import com.myimooc.sms.service.ServiceException;
import com.myimooc.sms.service.StudentService;

import java.util.List;
/**
 * <br>
 * 标题: 学生服务实现<br>
 * 描述: 学生服务实现<br>
 *
 * @author zc
 * @date 2018/05/29
 */
public class StudentServiceImpl implements StudentService {

    private PersistenceService persistenceService = PersistenceServiceLoader.persistenceService;

    @Override
    public List<Student> list() throws ServiceException {
        try {
            return persistenceService.list(Student.class);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Student getOne(String id) throws ServiceException {
        try {
            return persistenceService.getOne(Student.class,id);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void createStudent(Student student) throws ServiceException {
        try {
            persistenceService.save(student);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void createStudent(String id,String name,String group) throws ServiceException{
        this.createStudent(new Student(id,name,group));
    }

    @Override
    public void updateStudent(Student student) throws ServiceException {
        try {
            persistenceService.save(student);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void removeStudent(Student student) throws ServiceException {
        try {
            persistenceService.remove(Student.class,student.getId());
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }
}
