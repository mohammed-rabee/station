package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Integer> {
    List<Employee> findAllByBusyAndGrade(boolean busy, int grade);
    List<Employee> findAllByBusy(boolean busy);

//    @Query("from Employee e where e.name = :name")
//    List<Employee> findByQuery(@Param("name") String name);
}
