package com.example.Employee.DAO;

import com.example.Employee.EntityClass.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDAO extends CrudRepository<Employee,Integer> {
}
