package com.example.Employee.Service;

import com.example.Employee.DAO.EmployeeDAO;
import com.example.Employee.DTO.ContractEmployeeDTO;
import com.example.Employee.DTO.PermenantEmployeeDTO;
import com.example.Employee.EntityClass.ContractEmployee;
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

  @Autowired private ModelMapper mapper;

  public ResponseEntity<?> saveContractEmp(ContractEmployeeDTO dto) {
    dao.save(mapper.map(dto, ContractEmployee.class));
    return ResponseEntity.ok("Contact Employee saved successfully...");
  }

  public ResponseEntity<?> savePermenantEmp(PermenantEmployeeDTO dto) {
    dao.save(mapper.map(dto, PermenantEmployee.class));
    return ResponseEntity.ok("Permenent Employee saved successfully...");
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
}
