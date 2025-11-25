package com.example.Employee.DAO;

import com.example.Employee.EntityClass.Department;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptDAO extends CrudRepository<Department, Integer> {
  Optional<Department> findByDeptName(String deptName);
}
