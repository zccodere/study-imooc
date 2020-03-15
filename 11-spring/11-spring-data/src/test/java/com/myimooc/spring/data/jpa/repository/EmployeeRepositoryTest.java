package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.AbstractTestSupport;
import com.myimooc.spring.data.jpa.domain.Employee;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import java.util.ArrayList;
import java.util.List;

/**
 * EmployeeRepository 测试类
 *
 * @author zc 2017-04-24
 */
public class EmployeeRepositoryTest extends AbstractTestSupport {

    private EmployeeRepository employeeRepository;

    @Override
    public void initSub() {
        employeeRepository = ctx.getBean(EmployeeRepository.class);
    }

    @Test
    public void entityManageFactoryTest() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = ctx.getBean(LocalContainerEntityManagerFactoryBean.class);
        Assert.assertNotNull(entityManagerFactory);
    }

    @Test
    public void findByNameTest() {
        System.out.println(employeeRepository);
        Employee employee = employeeRepository.findByName("cc");
        if (null == employee) {
            System.out.println("查询数据为空");
        } else {
            System.out.println(employee.toString());
        }
    }

    @Test
    public void findByNameStartingWithAndAgeLessThanTest() {
        System.out.println(employeeRepository);
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("test", 22);

        if (null != employees) {
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        } else {
            System.out.println("查询数据为空");
        }
    }

    @Test
    public void findByNameEndingWithAndAgeLessThanTest() {
        System.out.println(employeeRepository);
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("6", 23);

        if (null != employees && employees.size() > 0) {
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        } else {
            System.out.println("查询数据为空");
        }
    }

    @Test
    public void findByNameInOrAgeLessThanTest() {
        List<String> names = new ArrayList<>(16);
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names, 22);

        if (null != employees && employees.size() > 0) {
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        } else {
            System.out.println("查询数据为空");
        }
    }

    @Test
    public void findByNameInAndAgeLessThanTest() {
        List<String> names = new ArrayList<>(16);
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInAndAgeLessThan(names, 22);

        if (null != employees && employees.size() > 0) {
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        } else {
            System.out.println("查询数据为空");
        }
    }

    //  使用 @Query 注解查询
    @Test
    public void getEmployeeByMaxIdTest() {

        Employee employee = employeeRepository.getEmployeeByMaxId();

        if (null != employee) {
            System.out.println(employee.toString());
        } else {
            System.out.println("查询数据为空");
        }
    }

    @Test
    public void listEmployeeByNameAndAgeTest() {
        List<Employee> employees = employeeRepository.listEmployeeByNameAndAge("tom", 20);
        if (null != employees && employees.size() > 0) {
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        } else {
            System.out.println("查询数据为空");
        }
    }

    @Test
    public void listEmployeeByNameAndAge2Test() {
        List<Employee> employees = employeeRepository.listEmployeeByNameAndAge2("mike", 20);
        if (null != employees && employees.size() > 0) {
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        } else {
            System.out.println("查询数据为空");
        }
    }

    @Test
    public void listEmployeeByLikeNameTest() {
        List<Employee> employees = employeeRepository.listEmployeeByLikeName("test1");
        if (null != employees && employees.size() > 0) {
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        } else {
            System.out.println("查询数据为空");
        }
    }

    @Test
    public void listEmployeeByLikeName2Test() {
        List<Employee> employees = employeeRepository.listEmployeeByLikeName2("test");
        if (null != employees && employees.size() > 0) {
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        } else {
            System.out.println("查询数据为空");
        }
    }

    @Test
    public void getCountTest() {
        long count = employeeRepository.getCount();
        System.out.println(count);
    }
}
