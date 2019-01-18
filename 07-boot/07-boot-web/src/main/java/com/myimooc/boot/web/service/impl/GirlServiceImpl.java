package com.myimooc.boot.web.service.impl;

import com.myimooc.boot.web.repository.GirlRepository;
import com.myimooc.boot.web.service.GirlService;
import com.myimooc.boot.web.utils.ResultResp;
import com.myimooc.boot.web.model.entity.Girl;
import com.myimooc.boot.web.exception.RespException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <br>
 * 标题: 业务服务实现<br>
 * 描述: 业务服务实现<br>
 * 时间: 2017/02/18<br>
 *
 * @author zc
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
    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        int primarySchool = 10;
        int middleSchool = 16;
        if (age < primarySchool) {
            //返回“你还在上小学吧”
            throw new RespException(ResultResp.PRIMARY_SCHOOL);
        } else if (age > primarySchool && age < middleSchool) {
            //返回“你可能在上初中”
            throw new RespException(ResultResp.MIDDLE_SCHOOL);
        }

        //如果>16岁，价钱
        //...
    }

    /**
     * 通过Id查询一个女生的信息
     *
     * @param id
     * @return
     */
    @Override
    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }
}
