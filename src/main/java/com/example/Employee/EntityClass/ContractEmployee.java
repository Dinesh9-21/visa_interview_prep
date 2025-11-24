package com.example.Employee.EntityClass;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ContractEmployee extends Employee{
    private int contract_duration;

    public int getContract_duration() {
        return contract_duration;
    }

    public void setContract_duration(int contract_duration) {
        this.contract_duration = contract_duration;
    }
}
