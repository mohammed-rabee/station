package com.example.demo.service;

import com.example.demo.entity.Call;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee assign () {
        List<Employee> employees = employeeRepository.findAllByBusyAndGrade(false , 1);
//        employees.get(0).addCalls(call);
        employees.get(0).setBusy(true);
        employeeRepository.saveAndFlush(employees.get(0));
        return employeeRepository.getOne(1);
    }
//
//    public void vipAssign ( Call call ) {
//
//    }
}
