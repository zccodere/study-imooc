package com.myimooc.boot.simple.service.impl;

import com.myimooc.boot.simple.model.entity.Girl;
import com.myimooc.boot.simple.service.GirlService;
import com.myimooc.boot.simple.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <br>
 * 标题: 服务实现<br>
 * 描述: 服务实现<br>
 * 时间: 2017/02/18<br>
 *
 * @author zc
 */
@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 保存两个女生信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(19);
        girlB.setCupSize("B");
        girlRepository.save(girlB);

    }
}
