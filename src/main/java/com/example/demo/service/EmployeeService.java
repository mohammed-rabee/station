package com.example.demo.service;

import com.example.demo.entity.Call;
import com.example.demo.entity.Employee;
import com.example.demo.repository.CallRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CallRepository callRepository;

    public EmployeeService(EmployeeRepository employeeRepository, CallRepository callRepository) {
        this.employeeRepository = employeeRepository;
        this.callRepository = callRepository;
    }

    public void endCall () throws InterruptedException {
        Thread.sleep(10000);
        List<Employee> employees = employeeRepository.findAllByBusy(true);
        for (int i = 0 ; i < employees.size() ; i++)
        {
            employees.get(i).setBusy(false);
            employeeRepository.saveAndFlush(employees.get(i));
        }

    }

    public void assign (Call call) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String comment = scanner.nextLine();
        List<Employee> employees = employeeRepository.findAllByBusyAndGrade(false, 1);
        if (!employees.isEmpty() && !comment.equalsIgnoreCase("can't handle") ){
            employees.get(0).setBusy(true);
            employeeRepository.saveAndFlush(employees.get(0));
            call.setEmployee(employeeRepository.getOne(employees.get(0).getId()));
            callRepository.save(call);
            System.out.println(comment);
//            return employees.get(0);
        } else {
            vipAssign(call);
        }
    }

    public void vipAssign (Call call) throws Exception {
        List<Employee> employees = employeeRepository.findAllByBusyAndGrade(false,2);
        if (!employees.isEmpty()) {
            employees.get(0).setBusy(true);
            call.setPriority("high");
            employeeRepository.saveAndFlush(employees.get(0));
            call.setEmployee(employeeRepository.getOne(employees.get(0).getId()));
            callRepository.save(call);
        } else {
            employees = employeeRepository.findAllByBusyAndGrade(false, 3);
            if (!employees.isEmpty()) {
                employees.get(0).setBusy(true);
                call.setPriority("high");
                employeeRepository.saveAndFlush(employees.get(0));
                call.setEmployee(employeeRepository.getOne(employees.get(0).getId()));
                callRepository.save(call);
            } else {
                throw new Exception("no one to handle the request");
            }
        }
    }
}
