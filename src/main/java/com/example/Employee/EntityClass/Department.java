package com.example.Employee.EntityClass;

import jakarta.persistence.*;
import java.util.List;

@Table(name = "department")
@Entity
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int dept_id;

  private String deptName;

// Refers to Employee's department field
  @OneToMany(
          mappedBy = "department",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<Employee> employee;

  public int getDept_id() {
    return dept_id;
  }

  public void setDept_id(int dept_id) {
    this.dept_id = dept_id;
  }

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }
}
