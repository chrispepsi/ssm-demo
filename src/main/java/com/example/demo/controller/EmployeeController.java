package com.example.demo.controller;

import com.example.demo.bean.Employee;
import com.example.demo.bean.Msg;
import com.example.demo.mapper.EmployeeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }

    @GetMapping("/emps")
    public Msg getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn,2);
        List<Employee> employees = employeeMapper.getAllEmps();
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(employees, 3);

        return Msg.success().add("pageInfo", pageInfo);
    }
}
