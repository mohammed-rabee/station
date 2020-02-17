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

    public String assign (Call call ) {
        List<Employee> employees = employeeRepository.findAllByStateAndGrade(false , 1);
//        employees.get(0).addCalls(call);
//        employees.get(0).setBusy(true);
//        employeeRepository.saveAndFlush(employees.get(0));
        return "test";
    }
//
//    public void vipAssign ( Call call ) {
//
//    }
}
