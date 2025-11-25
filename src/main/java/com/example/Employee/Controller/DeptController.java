package com.example.Employee.Controller;

import com.example.Employee.EntityClass.Department;
import com.example.Employee.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private EmpService service;

    @GetMapping("/departments")
    public ResponseEntity<?> getDepartments(){
        return service.getDepartments();
    }

    @PostMapping("/add_department")
    public ResponseEntity<?> addDepartment(@RequestParam("deptName") String deptName){
        return service.addDepartment(deptName);
    }
}
