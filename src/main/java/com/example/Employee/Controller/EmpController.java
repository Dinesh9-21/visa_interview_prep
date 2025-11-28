package com.example.Employee.Controller;

import com.example.Employee.DTO.ContractEmployeeDTO;
import com.example.Employee.DTO.PermenantEmployeeDTO;
import com.example.Employee.Service.EmpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpController {

  @Autowired private EmpService service;

  @PostMapping("/contract")
  public ResponseEntity<?> saveContractEmp(@RequestBody @Valid ContractEmployeeDTO dto) {
    return service.saveContractEmp(dto);
  }

  @PostMapping("/permenant")
  public ResponseEntity<?> savePermenantEmp(@RequestBody @Valid PermenantEmployeeDTO dto) {
    return service.savePermenantEmp(dto);
  }

  @GetMapping("/get_employees")
  public ResponseEntity<?> getEmployees() {
    return service.getEmployess();
  }


  @DeleteMapping("/delete_employee")
    public ResponseEntity<?> deleteEmployee(@RequestParam("name") String name){
      return service.deleteEmployeeByName(name);
  }

}
