package com.example.Employee.DAO;

import com.example.Employee.EntityClass.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;

import java.util.Optional;

@Repository
public interface DeptDAO extends CrudRepository<Department,Integer> {
    Optional<Department> findByDeptName(String deptName);
}
