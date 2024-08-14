package com.example.Employee_Retirement_Plan.repository;

import com.example.Employee_Retirement_Plan.dto.RetirementPlanResponseDto;
import com.example.Employee_Retirement_Plan.entity.RetirementPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RetirementPlanRepository extends JpaRepository<RetirementPlan, Long> {
     @Query("select r from RetirementPlan r where r.employee.employee_id= :employee_id")
     RetirementPlan findRetirementPlanByEmployeeEmployee_id(Long employee_id);
}
