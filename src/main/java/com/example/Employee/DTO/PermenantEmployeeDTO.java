package com.example.Employee.DTO;

import jakarta.persistence.Entity;
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
public class PermenantEmployeeDTO {
    @NotBlank(message = "Name must not be blank or empty...")
    private String name;
    private String dept;
    @Min(value = 100000,message = "Minimum salary must be more than 100000....")
    private Long salary;
    @PastOrPresent(message = "Join Date must be less than current day.....")
    private LocalDate joinDate;
    private Long benefits;

    public Long getBenefits() {
        return benefits;
    }

    public void setBenefits(Long benefits) {
        this.benefits = benefits;
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

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
}
