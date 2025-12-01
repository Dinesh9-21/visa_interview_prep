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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

  private static Logger logger = LoggerFactory.getLogger(EmpService.class);

  @Autowired private EmployeeDAO dao;

  @Autowired private DeptDAO dept_dao;

  @Autowired private ModelMapper mapper;

  public ResponseEntity<?> saveContractEmp(ContractEmployeeDTO dto) {
    logger.info("I am in the Save Contract Service Method..");
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
    logger.info("I am in the Save Permenant Employee Service method..");
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

  public ResponseEntity<?> getEmployess() {
    logger.info("I am in the Get Employees Service Method...");
    Pageable pageable = PageRequest.of(0, 5);
    Page<Employee> emps = dao.findAll(pageable);
    // List<Employee> emps = (List<Employee>) dao.findAll();
    Page<?> employees =
        emps.map(
            emp -> {
              if (emp instanceof ContractEmployee) {
                return mapper.map(emp, ContractEmployeeDTO.class);
              } else {
                return mapper.map(emp, PermenantEmployeeDTO.class);
              }
            });

    return new ResponseEntity<Page<?>>(employees, HttpStatus.OK);
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
    logger.info("I am in the Delete Employee service method...");
    dao.deleteById(id);
    return ResponseEntity.ok("Deletion done..... for the ID : " + id);
  }

  public ResponseEntity<?> deleteEmployeeByName(String name) {
    logger.info("I am in the delete Employee by name Service method...");
    dao.deleteByName(name);
    return new ResponseEntity<>("Emp Deleted", HttpStatus.OK);
  }

  public ResponseEntity<?> getDepartments() {
    logger.info("I am in the Get Departments Service method....");
    List<Department> departments = (List<Department>) dept_dao.findAll();
    return new ResponseEntity<>(departments, HttpStatus.OK);
  }

  public ResponseEntity<?> addDepartment(String dept) {
    logger.info("I am in the Add Department Service method.....");
    if (!dept_dao.findByDeptName(dept).isPresent()) {
      Department department = new Department();
      department.setDeptName(dept);
      dept_dao.save(department);
      return ResponseEntity.ok("Department Created..");
    }
    return new ResponseEntity<>(
        "Department with provided name already exists", HttpStatus.NOT_ACCEPTABLE);
  }

  public ResponseEntity<?> deleteDepartment(int dept_id) {
    logger.info(" I am in the Delete Department Service method .....");
    dept_dao.deleteById(dept_id);
    return new ResponseEntity<>("Deleted Department ", HttpStatus.OK);
  }
}
