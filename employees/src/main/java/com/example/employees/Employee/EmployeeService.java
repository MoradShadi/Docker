package com.example.employees.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

        private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getEmployees(){
        return employeeRepo.findAll();
    }

    public void addNewEmployee(Employee employee){
        employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        boolean exists = employeeRepo.existsById(id);

        if(!exists){
            throw new IllegalStateException("Employee does not exist");
        }

        employeeRepo.deleteById(id);
    }
}
