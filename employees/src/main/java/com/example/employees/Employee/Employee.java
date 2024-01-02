package com.example.employees.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(
        name = "employee_sequence",
        sequenceName = "employee_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "employee_sequence")
    private long id;
    private String name;
    private String email;
    private Integer age;

    
    public Employee() {
    }


    public Employee(long id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
    
    public Employee(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + "]";
    }

}
