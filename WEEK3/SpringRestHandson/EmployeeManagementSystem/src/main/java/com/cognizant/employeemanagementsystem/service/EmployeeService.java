package com.cognizant.employeemanagementsystem.service;

import com.cognizant.employeemanagementsystem.dao.EmployeeDao;
import com.cognizant.employeemanagementsystem.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public ArrayList<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
}