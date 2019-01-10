package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) entityManager.createQuery("from Employee").getResultList();
    }

    @Override
    public Employee findById(int theId) {
        return entityManager.find(Employee.class, theId);
    }

    @Override
    public void save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        dbEmployee.setId(employee.getId());
    }

    @Override
    public void deleteById(int theId) {
        Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();
    }
}
