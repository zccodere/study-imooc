package com.myimooc.boot.web.service.impl;

import com.myimooc.boot.web.exception.ResponseException;
import com.myimooc.boot.web.model.entity.Girl;
import com.myimooc.boot.web.repository.GirlRepository;
import com.myimooc.boot.web.service.GirlService;
import com.myimooc.boot.web.utils.ResultResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * 服务层实现
 *
 * @author zc 2017-02-18
 */
@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 插入两个女生信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveTwo() {
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(19);
        girlB.setCupSize("B");
        girlRepository.save(girlB);
    }

    @Override
    public void getAge(Integer id) throws ResponseException {
        Girl girl = girlRepository.findById(id).orElse(null);
        if (Objects.isNull(girl)) {
            return;
        }

        Integer age = girl.getAge();
        int primarySchool = 10;
        int middleSchool = 16;
        if (age < primarySchool) {
            // 返回“你还在上小学吧”
            throw new ResponseException(ResultResponse.PRIMARY_SCHOOL);
        } else if (age > primarySchool && age < middleSchool) {
            // 返回“你可能在上初中”
            throw new ResponseException(ResultResponse.MIDDLE_SCHOOL);
        }

        //如果>16岁，价钱
        //...
    }

    /**
     * 通过Id查询一个女生的信息
     */
    @Override
    public Girl findOne(Integer id) {
        return girlRepository.findById(id).orElse(null);
    }
}
