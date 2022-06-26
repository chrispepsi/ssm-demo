package com.example.demo.mapper;

import com.example.demo.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public List<Employee> getAllEmps();

    public void insertEmp(Employee employee);
}
