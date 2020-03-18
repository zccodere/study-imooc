package com.myimooc.ssh.employee.action;

import com.myimooc.ssh.employee.domain.Department;
import com.myimooc.ssh.employee.domain.PageBean;
import com.myimooc.ssh.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 部门管理的Action类
 *
 * @author zc 2017-08-18
 */
@Controller()
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

    private static final long serialVersionUID = 1L;

    private Department department = new Department();

    @Autowired
    private DepartmentService departmentService;

    @Override
    public Department getModel() {
        return department;
    }

    /**
     * 当前页
     */
    private Integer currPage = 1;

    /**
     * 分页查询全部部门
     */
    public String findAll() {
        PageBean<Department> pageBean = departmentService.findByPage(currPage);
        // 将pageBean存入到值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    /**
     * 跳转到添加部门页面
     */
    public String saveUi() {
        return "saveUi";
    }

    /**
     * 添加部门
     */
    public String save() {
        departmentService.save(department);
        return "saveSuccess";
    }

    /**
     * 查询部门信息并跳转到部门管理页面
     */
    public String edit() {
        department = departmentService.findById(department.getDid());
        return "editSuccess";
    }

    /**
     * 修改部门
     */
    public String update() {
        departmentService.update(department);
        return "updateSuccess";
    }

    /**
     * 删除部门
     */
    public String delete() {
        department = departmentService.findById(department.getDid());
        departmentService.delete(department);
        return "deleteSuccess";
    }
}
