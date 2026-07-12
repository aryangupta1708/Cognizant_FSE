package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Skill;
import java.util.Set;

@SpringBootApplication
public class OrmLearnApplication {

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

//        testGetEmployee();
//        testAddEmployee();
//        testUpdateEmployee();
//        testGetDepartment();
        testAddSkillToEmployee();
    }

    private static void testGetEmployee() {

        System.out.println("Employee Details");

        Employee employee = employeeService.get(4);

        System.out.println(employee);

        System.out.println(employee.getDepartment());

        System.out.println(employee.getSkillList());
    }
    private static void testAddEmployee() {

        Employee employee = new Employee();

        employee.setName("Rohit");
        employee.setSalary(55000);
        employee.setPermanent(true);
        employee.setDateOfBirth(new java.util.Date());


        Department department = departmentService.get(1);

        employee.setDepartment(department);

        employeeService.save(employee);

        System.out.println(employee);
    }
    private static void testUpdateEmployee() {

        System.out.println("Updating Employee...");

        // Employee fetch karo
        Employee employee = employeeService.get(7);

        // Naya Department fetch karo
        Department department = departmentService.get(1);


        // Department change karo
        employee.setDepartment(department);

        // Save
        employeeService.save(employee);

        System.out.println(employee);
    }
    private static void testGetDepartment() {

        System.out.println("Department Details");

        Department department = departmentService.get(2);

        System.out.println(department);

        System.out.println(department.getEmployeeList());
    }
    private static void testAddSkillToEmployee() {

        System.out.println("Adding Skill to Employee");

        // Employee fetch karo
        Employee employee = employeeService.get(5);

        // Skill fetch karo
        Skill skill = skillService.get(2);

        // Skill list nikalo
        Set<Skill> skillList = employee.getSkillList();

        // Skill add karo
        skillList.add(skill);

        // Save employee
        employeeService.save(employee);

        System.out.println(employee);
        System.out.println(employee.getSkillList());
    }
}

