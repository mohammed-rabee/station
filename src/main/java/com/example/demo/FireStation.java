package com.example.demo;

import com.example.demo.entity.Call;
import com.example.demo.entity.Employee;
import com.example.demo.repository.CallRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.CallService;
import com.example.demo.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.Scanner;

@SpringBootApplication
public class FireStation {
    public static void main(String[] args) {
        SpringApplication.run(FireStation.class, args);
    }

    @Bean
    public CommandLineRunner demo (CallRepository callRepository,
                                   EmployeeRepository employeeRepository,
                                   CallService callService,
                                   EmployeeService employeeService) {
        return args -> {
            Employee employee = new Employee("nazeh", 1, null , false);
            employeeRepository.save(employee);

            Employee employee1 = new Employee("lama", 1, null , false);
            employeeRepository.save(employee1);

            Employee employee2 = new Employee("ahlam", 2,null , false);
            employeeRepository.save(employee2);

            Employee employee3 = new Employee("mohammed", 2,null , false);
            employeeRepository.save(employee3);

            Employee employee4 = new Employee("ibrahim", 3,null , false);
            employeeRepository.save(employee4);

            Employee employee5 = new Employee("adham", 3, null , false);
            employeeRepository.save(employee5);

            Scanner scan = new Scanner(System.in);
            Call call = new Call();

            System.out.println("Enter the caller name");
            call.setCaller(scan.nextLine());

            System.out.println("Enter the call Priority");
            call.setPriority(scan.nextInt());
            call.setEmployee(employeeService.assign());
            callRepository.save(call);


        };
    }



}
