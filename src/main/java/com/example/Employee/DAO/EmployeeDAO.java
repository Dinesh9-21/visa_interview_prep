package com.example.Employee.DAO;

import com.example.Employee.EntityClass.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeDAO extends CrudRepository<Employee, Integer> {
    @Transactional
    int deleteByName(String name);
}
