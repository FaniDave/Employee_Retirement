package com.example.Employee_Retirement_Plan.repository;

import com.example.Employee_Retirement_Plan.dto.RetirementPlanResponseDto;
import com.example.Employee_Retirement_Plan.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Query method to find employees by retirement date through their retirement plan
    List<Employee> findByRetirementPlan_RetirementDateBetween(LocalDate startDate, LocalDate endDate);
}

