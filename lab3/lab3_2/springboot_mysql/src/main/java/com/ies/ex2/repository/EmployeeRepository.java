package com.ies.ex2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ies.ex2.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    //@Query("SELECT * FROM employees e WHERE e.emailId = :emailId")
    public Employee findByEmailId(@Param("emailId") String emailId);
}
