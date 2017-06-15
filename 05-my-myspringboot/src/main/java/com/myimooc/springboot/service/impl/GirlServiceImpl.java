package com.myimooc.springboot.service.impl;

import com.myimooc.springboot.model.entity.Girl;
import com.myimooc.springboot.repository.GirlRepository;
import com.myimooc.springboot.service.GirlService;
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
}
