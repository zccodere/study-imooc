package com.myimooc.ssh.employee.action;

import com.myimooc.ssh.employee.domain.Department;
import com.myimooc.ssh.employee.domain.Employee;
import com.myimooc.ssh.employee.domain.PageBean;
import com.myimooc.ssh.employee.service.DepartmentService;
import com.myimooc.ssh.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 员工管理的Action类
 *
 * @author zc 2017-08-18
 */
@Controller()
@Scope("prototype")
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {

    private static final long serialVersionUID = 1L;
    /**
     * 模型驱动需要使用的对象
     */
    private Employee employee = new Employee();
    /**
     * 接收当前的页数
     */
    private Integer currPage = 1;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @Override
    public Employee getModel() {
        return employee;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    /**
     * 登录执行的方法
     */
    public String login() {
        System.out.println("login执行了..." + String.valueOf(employee));
        Employee existEmployee = employeeService.login(employee);
        if (existEmployee == null) {
            // 登录失败
            this.addActionError("用户名或密码错误！");
            return INPUT;
        } else {
            // 登录成功
            ActionContext.getContext().getSession().put("existEmployee", existEmployee);
            return SUCCESS;
        }
    }

    /**
     * 分页查询员工信息
     */
    public String findAll() {
        PageBean<Employee> pageBean = employeeService.findByPage(currPage);
        // 将pageBean存入栈中，以便于页面上通过struts标签来获取值
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    /**
     * 跳转到新增员工信息页面
     */
    public String saveUi() {
        List<Department> list = departmentService.findAll();
        // 集合用set。对象用push
        ActionContext.getContext().getValueStack().set("list", list);
        return "saveUi";
    }

    /**
     * 保存员工信息
     */
    public String save() {
        employeeService.save(employee);
        return "saveSuccess";
    }

    /**
     * 跳转到编辑员工嘻嘻页面
     */
    public String edit() {
        // 根据员工ID查询员工
        employee = employeeService.findById(employee.getEid());
        // 查询所有部门
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list", list);
        return "editSuccess";
    }

    /**
     * 修改员工信息
     */
    public String update() {
        employeeService.update(employee);
        return "updateSuccess";
    }

    /**
     * 删除员工信息
     */
    public String delete() {
        employee = employeeService.findById(employee.getEid());
        employeeService.delete(employee);
        return "deleteSuccess";
    }
}
