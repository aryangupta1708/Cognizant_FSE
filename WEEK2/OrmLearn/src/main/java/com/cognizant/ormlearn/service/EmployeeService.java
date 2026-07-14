package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Employee get(int id) {
        return employeeRepository.findById(id).get();
    }

    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    public List<Employee> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees();
    }

    @Transactional
    public double getAverageSalary(int id) {
        return employeeRepository.getAverageSalary(id);
    }

    @Transactional
    public List<Employee> getAllEmployeesNative() {
        return employeeRepository.getAllEmployeesNative();
    }

    @Transactional
    public List<Employee> getPermanentEmployeesCriteria() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);

        cq.select(employee);

        cq.where(cb.equal(employee.get("permanent"), true));

        TypedQuery<Employee> query = entityManager.createQuery(cq);

        return query.getResultList();
    }
}