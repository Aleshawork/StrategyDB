package com.myService.Service.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "emps")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @JsonProperty("id")
    private Long id;

    @Column(name="name")
    @JsonProperty("name")
    private String name;

    @Column(name="department")
    @JsonProperty("department")
    private String department;

    @Column(name="salary")
    @JsonProperty("salary")
    private int salary;

    @Column(name="hire_date")
    @JsonProperty("date")
    private Date date;

    public Employees() {
    }

    public Employees(Long id, String name, String department, int salary, Date date) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
