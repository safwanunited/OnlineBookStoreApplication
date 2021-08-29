package com.revature.bookproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.revature.bookproject.model.Employee;
@Component
public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer>{
      
}
