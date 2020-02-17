package com.example.demo.entity;

import java.util.Set;

import javafx.util.Pair;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Columns;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Null;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int grade;

    @OneToMany (mappedBy = "employee")
    private Set<Call> calls;
    private boolean busy;

    public Employee(String name, int grade, Set<Call> calls, boolean busy) {
        this.name = name;
        this.grade = grade;
        this.calls = calls;
        this.busy = busy;
    }

    public void addCalls (Call call) {
        calls.add(call);
    }

}