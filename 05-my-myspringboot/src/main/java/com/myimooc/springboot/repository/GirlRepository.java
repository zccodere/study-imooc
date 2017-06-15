package com.myimooc.springboot.repository;

import com.myimooc.springboot.model.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ChengComputer on 2017/2/18.
 * @author zhangcheng
 * @version v1.0
 * @date 2017-02-18
 */
public interface GirlRepository extends JpaRepository<Girl,Integer>{

    /**
     * 通过年龄来查询
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);
}
