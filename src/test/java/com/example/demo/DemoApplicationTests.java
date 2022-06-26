package com.example.demo;

import com.example.demo.bean.Employee;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.mapper.EmployeeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;


    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void testMybatis() {
        PageHelper.startPage(2,2);
        List<Employee> employees = employeeMapper.getAllEmps();
        PageInfo<Employee> info = new PageInfo<Employee>(employees, 3);

        System.out.println(employees);
        System.out.println(Arrays.toString(info.getNavigatepageNums()));
    }

}
