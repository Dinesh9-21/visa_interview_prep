package com.example.Employee.Controller;

import com.example.Employee.DTO.ContractEmployeeDTO;
import com.example.Employee.DTO.PermenantEmployeeDTO;
import com.example.Employee.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpController {

    @Autowired
    private EmpService service;


    @PostMapping("/contract")
    public ResponseEntity<?> saveContractEmp(@RequestBody ContractEmployeeDTO dto){
        return service.saveContractEmp(dto);
    }

    @PostMapping("/permenant")
    public ResponseEntity<?> savePermenantEmp(@RequestBody PermenantEmployeeDTO dto){
        return service.savePermenantEmp(dto);
    }

    @GetMapping("/get_employees")
    public ResponseEntity<?> getEmployees(){
        return service.getContractEmployess();
    }


}
