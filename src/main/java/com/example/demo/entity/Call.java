package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Call {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String Caller;
    private String priority;

    @ManyToOne
    private Employee employee;

    public Call(String caller, String priority, Employee employee) {
        Caller = caller;
        this.priority = priority;
        this.employee = employee;
    }
}
