package com.example.demothymeleaf.repository;

import com.example.demothymeleaf.model.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmployeeRepository {
    @Select("""
            SELECT * FROM employee
            """)
    @Results(id = "empMapper", value = {
            @Result(property = "id", column = "emp_id"),
            @Result(property = "name", column = "emp_name"),
            @Result(property = "gender", column = "emp_gender")
    })
    List<Employee> getAllEmployees();


    @Insert("""
            INSERT INTO employee(emp_name, emp_gender)
            VALUES (#{emp.name}, #{emp.gender})
            """)
    @ResultMap("empMapper")
    void addEmployee(@Param("emp") Employee employee);

    @Select("""
            SELECT * FROM employee
            WHERE emp_id = #{id}
            """)
    @ResultMap("empMapper")
    Employee getEmployeeById(Integer id);

    @Update("""
            UPDATE employee
            SET emp_name = #{emp.name}, emp_gender = #{emp.gender}
            WHERE emp_id = #{id}
            """)
    @ResultMap("empMapper")
    void editEmployee(@Param("emp") Employee employee, Integer id);


    @Delete("""
            DELETE FROM employee
            WHERE emp_id = #{id}
            """)
    @ResultMap("empMapper")
    void deleteEmployee(Integer id);
}

