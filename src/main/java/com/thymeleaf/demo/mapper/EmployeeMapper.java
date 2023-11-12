package com.thymeleaf.demo.mapper;

import com.thymeleaf.demo.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Select("SELECT * FROM employee")
    List<Employee> selectAll();
    @Select("SELECT * FROM employee WHERE id=#{id}")
    Employee selectById(int id);
    @Insert("INSERT INTO employee(name, phone, address) VALUES(#{name}, #{phone}, #{address})")
    int insert(Employee employee);
    @Update("UPDATE employee SET name=#{name}, phone=#{phone}, address=#{address} WHERE id=#{id}")
    int update(Employee employee);
    @Delete("DELETE FROM employee WHERE id=#{id}")
    int delete(int id);
}
