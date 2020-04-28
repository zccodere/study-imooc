package com.myimooc.boot.simple.controller;

import com.myimooc.boot.simple.model.entity.Girl;
import com.myimooc.boot.simple.repository.GirlRepository;
import com.myimooc.boot.simple.service.GirlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Girl 控制层
 *
 * @author zc 2017-02-18
 */
@RestController
@RequestMapping("/girls")
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     */
    @GetMapping
    public List<Girl> listGirl() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     */
    @PostMapping
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    /**
     * 查询一个女生
     */
    @GetMapping("/{id}")
    public Girl getGirlById(@PathVariable("id") Integer id) {
        return girlRepository.findById(id).orElse(null);
    }

    /**
     * 更新女生信息
     */
    @PutMapping("/{id}")
    public Girl updateGirlById(@PathVariable("id") Integer id,
                               @RequestParam("cupSize") String cupSize,
                               @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除女生信息
     */
    @DeleteMapping("/{id}")
    public void removeGirl(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    /**
     * 通过年龄查询女生列表
     */
    @GetMapping("/age/{age}")
    public List<Girl> listGirlByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping("/two")
    public void saveGirlTwo() {
        girlService.saveTwo();
    }

}
