package com.example.Employee.DAO;

import com.example.Employee.EntityClass.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
  @Transactional
  void deleteByName(String name);
}
