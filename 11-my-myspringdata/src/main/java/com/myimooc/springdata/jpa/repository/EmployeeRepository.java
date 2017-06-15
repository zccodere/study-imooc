package com.myimooc.springdata.jpa.repository;

import com.myimooc.springdata.jpa.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 使用 Repository 接口
 * Created by ZC on 2017/4/25.
 */
// 方式二：使用 @RepositoryDefinition 注解
//  @RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
public interface EmployeeRepository extends Repository<Employee,Integer> {//方式一：继承 Repository 接口

    /**
     * 获取雇员对象通过名称
     * @param name
     * @return
     */
    Employee findByName(String name);

    // 使用JPA规范查询

    // where name like ?% and age < ?
    List<Employee> findByNameStartingWithAndAgeLessThan(String name,Integer age);

    // where name like %? and age < ?
    List<Employee> findByNameEndingWithAndAgeLessThan(String name,Integer age);

    // where name in (?,?...) or age < ?
    List<Employee> findByNameInOrAgeLessThan(List<String> name,Integer age);

    // where name in (?,?...) and age < ?
    List<Employee> findByNameInAndAgeLessThan(List<String> name,Integer age);

    // 使用@Query注解查询

    /**
     * 自定义查询SQL
     * */
    @Query("select o from Employee o where id=(select max(id) from Employee t1)")
    Employee getEmployeeByMaxId();

    /**
     * 使用占位符进行参数绑定
     * */
    @Query("select o from Employee o where o.name=?1 and o.age=?2")
    List<Employee> listEmployeeByNameAndAge(String name, Integer age);

    /**
     * 使用命名参数进行参数绑定
     * */
    @Query("select o from Employee o where o.name=:name and o.age=:age")
    List<Employee> listEmployeeByNameAndAge2(@Param("name") String name, @Param("age")Integer age);

    /**
     * 自定义查询SQL，like,占位符进行参数绑定
     * */
    @Query("select o from Employee o where o.name like %?1%")
    List<Employee> listEmployeeByLikeName(String name);

    /**
     * 自定义查询SQL，like,命名参数进行参数绑定
     * */
    @Query("select o from Employee o where o.name like %:name%")
    List<Employee> listEmployeeByLikeName2(@Param("name") String name);

    /**
     * 使用原生态SQL查询
     * @return
     */
    @Query(nativeQuery = true,value = "select count(1) from employee")
    long getCount();

    // 更新数据
    @Transactional
    @Modifying
    @Query("update Employee o set o.age = :age where o.id = :id")
    void updateAgeById(@Param("id")Integer id,@Param("age")Integer age);
}
