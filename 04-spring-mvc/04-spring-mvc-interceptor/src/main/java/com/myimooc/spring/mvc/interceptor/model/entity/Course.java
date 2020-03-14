package com.myimooc.spring.mvc.interceptor.model.entity;

import java.util.List;

/**
 * 课程实体类
 *
 * @author zc 2017-02-18
 */
public class Course {

    /**
     * 课程ID
     */
    private Integer courseId;
    /**
     * 课程名称
     */
    private String title;
    /**
     * 图片路径
     */
    private String imgPath;
    /**
     * 学习人数
     */
    private Integer learnNum;
    /**
     * 课程时长
     */
    private Long duration;
    /**
     * 课程难度
     */
    private Integer level;
    /**
     * 课程难度描述
     */
    private String levelDesc;
    /**
     * 课程介绍
     */
    private String description;
    /**
     * 章节列表
     */
    private List<Chapter> chapterList;

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", learnNum=" + learnNum +
                ", duration=" + duration +
                ", level=" + level +
                ", levelDesc='" + levelDesc + '\'' +
                ", description='" + description + '\'' +
                ", chapterList=" + chapterList +
                '}';
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getLearnNum() {
        return learnNum;
    }

    public void setLearnNum(Integer learnNum) {
        this.learnNum = learnNum;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevelDesc() {
        return levelDesc;
    }

    public void setLevelDesc(String levelDesc) {
        this.levelDesc = levelDesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }
}
