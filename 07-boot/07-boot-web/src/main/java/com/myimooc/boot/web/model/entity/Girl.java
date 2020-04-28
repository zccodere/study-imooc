package com.myimooc.boot.web.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 实体类
 *
 * @author zc 2017-02-18
 */
@Entity(name = "TAM_GIRL_INFO")
public class Girl {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 大小
     */
    private String cupSize;
    /**
     * 年龄
     */
    @Min(value = 18, message = "未成年少女禁止入内")
    private Integer age;
    /**
     * 金额
     */
    @NotNull(message = "金额必传")
    private Integer money;

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
