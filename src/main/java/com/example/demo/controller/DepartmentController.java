package com.example.demo.controller;

import com.example.demo.bean.Department;
import com.example.demo.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

}
