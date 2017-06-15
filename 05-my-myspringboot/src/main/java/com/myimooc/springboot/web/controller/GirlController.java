package com.myimooc.springboot.web.controller;

import com.myimooc.springboot.model.entity.Girl;
import com.myimooc.springboot.repository.GirlRepository;
import com.myimooc.springboot.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ChengComputer on 2017/2/18.
 *
 * @author zhangcheng
 * @version v1.0
 * @date 2017-02-18
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value="/girls")
    public List<Girl> listGirl(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value="/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);

    }

    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value="/girls/{id}")
    public Girl getGirlById(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 更新女生信息
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value="/girls/{id}")
    public Girl updateGirlById(@PathVariable("id") Integer id,
                               @RequestParam("cupSize") String cupSize,
                               @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);

    }

    /**
     * 删除女生信息
     * @param id
     */
    @DeleteMapping(value="/girls/{id}")
    public void removeGirl(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 通过年龄查询女生列表
     * @param age
     * @return
     */
    @GetMapping(value="/girls/age/{age}")
    public List<Girl> listGirlByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value="/girls/two")
    public void saveGirlTwo(){
        girlService.saveTwo();
    }

}
