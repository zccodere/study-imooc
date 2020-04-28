package com.myimooc.spring.mvc.simple.model.entity;

/**
 * 课程章节实体类
 *
 * @author zc 2017-02-18
 */
public class Chapter {

    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 课程ID
     */
    private Integer courseId;
    /**
     * 章节序号
     */
    private Integer order;
    /**
     * 章节标题
     */
    private String title;
    /**
     * 章节描述
     */
    private String description;

//    private List<Section> sectionList;

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", order=" + order +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
