package com.example.Employee.Service;

import com.example.Employee.DAO.DeptDAO;
import com.example.Employee.DAO.EmployeeDAO;
import com.example.Employee.DTO.ContractEmployeeDTO;
import com.example.Employee.DTO.PermenantEmployeeDTO;
import com.example.Employee.EntityClass.ContractEmployee;
import com.example.Employee.EntityClass.Department;
import com.example.Employee.EntityClass.Employee;
import com.example.Employee.EntityClass.PermenantEmployee;
import com.example.Employee.ExceptionHandler.EmployeeNotFoundException;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

  @Autowired private EmployeeDAO dao;

  @Autowired private DeptDAO dept_dao;

  @Autowired private ModelMapper mapper;

  public ResponseEntity<?> saveContractEmp(ContractEmployeeDTO dto) {

    if (!(dto.getDepartment().getDeptName() == null)) {
      Department dept =
          (Department)
              dept_dao
                  .findByDeptName(dto.getDepartment().getDeptName())
                  .orElseThrow(
                      () ->
                          new RuntimeException(
                              "Department with provided Dept Name is no present...."));
      ContractEmployee emp = mapper.map(dto, ContractEmployee.class);
      emp.setDepartment(dept);
      dao.save(emp);
    }
    return ResponseEntity.ok("Contact Employee saved successfully...");
  }

  public ResponseEntity<?> savePermenantEmp(PermenantEmployeeDTO dto) {
    if (!(dto.getDepartment().getDeptName() == null)) {
      Department dept =
          (Department)
              dept_dao
                  .findByDeptName(dto.getDepartment().getDeptName())
                  .orElseThrow(
                      () ->
                          new RuntimeException(
                              "Department with provided Dept Name is no present...."));
      PermenantEmployee emp = mapper.map(dto, PermenantEmployee.class);
      emp.setDepartment(dept);
      dao.save(emp);
      return ResponseEntity.ok("Permenent Employee saved successfully...");
    }

    return new ResponseEntity<>("Department name must not be Empty... ", HttpStatus.NOT_ACCEPTABLE);
  }

  public ResponseEntity<?> getContractEmployess() {
    List<Employee> emps = (List<Employee>) dao.findAll();
    List<?> employees =
        emps.stream()
            .map(
                emp -> {
                  if (emp instanceof ContractEmployee) {
                    return mapper.map(emp, ContractEmployeeDTO.class);
                  } else {
                    return mapper.map(emp, PermenantEmployeeDTO.class);
                  }
                })
            .toList();
    return new ResponseEntity<List<?>>(employees, HttpStatus.OK);
  }

  public ResponseEntity<?> getEmployee(int id) {
    Employee employee =
        dao.findById(id)
            .orElseThrow(
                () ->
                    new EmployeeNotFoundException("Employee with id : " + id + " not present..."));
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  public ResponseEntity<?> deleteEmployee(int id) {
    dao.deleteById(id);
    return ResponseEntity.ok("Deletion done..... for the ID : " + id);
  }

  public ResponseEntity<?> getDepartments() {
    List<Department> departments = (List<Department>) dept_dao.findAll();
    return new ResponseEntity<>(departments, HttpStatus.OK);
  }

  public ResponseEntity<?> addDepartment(String dept) {

    if (!dept_dao.findByDeptName(dept).isPresent()) {
      Department department = new Department();
      department.setDeptName(dept);
      dept_dao.save(department);
      return ResponseEntity.ok("Department Created..");
    }
    return new ResponseEntity<>(
        "Department with provided name already exists", HttpStatus.NOT_ACCEPTABLE);
  }
}
