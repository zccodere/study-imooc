package com.myimooc.boot.web.controller;

import com.myimooc.boot.web.model.entity.Girl;
import com.myimooc.boot.web.model.entity.Result;
import com.myimooc.boot.web.repository.GirlRepository;
import com.myimooc.boot.web.service.GirlService;
import com.myimooc.boot.web.utils.ResultUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

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
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (Objects.nonNull(fieldError)) {
                return ResultUtil.error(ResultUtil.RESPONSE_CODE_ERROR_PARAM, fieldError.getDefaultMessage());
            }
            return ResultUtil.error(ResultUtil.RESPONSE_CODE_ERROR_PARAM, "未知参数错误");
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil.success(girlRepository.save(girl));
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

    @GetMapping(value = "/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) {
        girlService.getAge(id);
    }

}
