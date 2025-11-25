package com.example.Employee.DTO;

import com.example.Employee.EntityClass.Department;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermenantEmployeeDTO {
  @NotBlank(message = "Name must not be blank or empty...")
  private String name;

  private Department department;

  @Min(value = 100000, message = "Minimum salary must be more than 100000....")
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

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public LocalDate getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(LocalDate joinDate) {
    this.joinDate = joinDate;
  }
}
