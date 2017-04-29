package com.myimooc.springbootweb.service.impl;

import com.myimooc.springbootweb.model.entity.Girl;
import com.myimooc.springbootweb.repository.GirlRepository;
import com.myimooc.springbootweb.service.GirlService;
import com.myimooc.springbootweb.exception.RespException;
import com.myimooc.springbootweb.utils.ResultResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ChengComputer on 2017/2/18.
 */
@Service
public class GirlServiceImpl implements GirlService{

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 插入两个女生信息
     */
    @Transactional
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
    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10){
            //返回“你还在上小学吧”
            throw new RespException(ResultResp.PRIMARY_SCHOOL);
        }else if(age >10 && age<16){
            //返回“你可能在上初中”
            throw new RespException(ResultResp.MIDDLE_SCHOOL);
        }

        //如果>16岁，价钱
        //...
    }

    /**
     * 通过Id查询一个女生的信息
     * @param id
     * @return
     */
    @Override
    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }
}
