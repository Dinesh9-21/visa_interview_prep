package com.example.Employee.EntityClass;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PermenantEmployee extends Employee {
  private Long benefits;

  public Long getBenefits() {
    return benefits;
  }

  public void setBenefits(Long benefit) {
    benefits = benefit;
  }
}
