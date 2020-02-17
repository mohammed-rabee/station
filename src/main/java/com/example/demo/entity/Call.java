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
    private int priority;

    @ManyToOne
    private Employee employee;

    public Call(String caller, int priority, Employee employee) {
        Caller = caller;
        this.priority = priority;
        this.employee = employee;
    }
}
