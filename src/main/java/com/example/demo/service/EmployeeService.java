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

    public Employee assign () throws Exception {
        List<Employee> employees = employeeRepository.findAllByBusyAndGrade(false, 1);
        if (!employees.isEmpty()) {
            employees.get(0).setBusy(true);
            employeeRepository.saveAndFlush(employees.get(0));
            return employees.get(0);
        } else {
            employees = employeeRepository.findAllByBusyAndGrade(false, 2);
            if (!employees.isEmpty()) {
                employees.get(0).setBusy(true);
                employeeRepository.saveAndFlush(employees.get(0));
                return employees.get(0);
            } else {
                employees = employeeRepository.findAllByBusyAndGrade(false, 3);
                if (!employees.isEmpty()) {
                    employees.get(0).setBusy(true);
                    employeeRepository.saveAndFlush(employees.get(0));
                    return employees.get(0);
                } else {
                    throw new Exception("no one to handle the request");
                }
            }
        }
    }

    public Employee vipAssign () throws Exception {
        List<Employee> employees = employeeRepository.findAllByBusyAndGrade(false,2);
        if (!employees.isEmpty()) {
            employees.get(0).setBusy(true);
            employeeRepository.saveAndFlush(employees.get(0));
            return employees.get(0);
        } else {
            employees = employeeRepository.findAllByBusyAndGrade(false, 3);
            if (!employees.isEmpty()) {
                employees.get(0).setBusy(true);
                employeeRepository.saveAndFlush(employees.get(0));
                return employees.get(0);
            } else {
                throw new Exception("no one to handle the request");
            }
        }
    }
}
