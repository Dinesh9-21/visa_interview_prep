package com.example.Employee.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractEmployeeDTO {

    @NotBlank(message = "Name must not be empty or nulll....")
    private String name;
    private String dept;
    @Min(value = 100000,message = "Salary must be min of 100000......")
    private  Long salary;
    @PastOrPresent(message = "Your join date must be less than your current date..")
    private LocalDate joinDate;
    @Min(value = 1,message = "Minimum contract duration must be 1 year...")
    private int contract_duration;

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public int getContract_duration() {
        return contract_duration;
    }

    public void setContract_duration(int contract_duration) {
        this.contract_duration = contract_duration;
    }



    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
