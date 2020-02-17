package com.example.demo.repository;

import com.example.demo.entity.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallRepository extends JpaRepository <Call , Integer> {
}
