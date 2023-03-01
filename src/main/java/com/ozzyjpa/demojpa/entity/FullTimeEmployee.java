package com.ozzyjpa.demojpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;


@Entity
public class FullTimeEmployee extends Employee{

    private BigDecimal salary;

    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }
    protected FullTimeEmployee() {}

}
