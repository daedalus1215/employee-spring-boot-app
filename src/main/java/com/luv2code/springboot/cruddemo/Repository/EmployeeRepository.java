package com.luv2code.springboot.cruddemo.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


//it is defaulted to /employees anyways, I just wanted to be explicit - we can change it to any end-route we want.
@RepositoryRestResource(path="/employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
