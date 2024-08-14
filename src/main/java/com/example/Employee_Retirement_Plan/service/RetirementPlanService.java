package com.example.Employee_Retirement_Plan.service;

import com.example.Employee_Retirement_Plan.dto.Employee_Retirement_requestDto;
import com.example.Employee_Retirement_Plan.dto.RetirementPlanResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface RetirementPlanService {
    RetirementPlanResponseDto save(Employee_Retirement_requestDto employee_retirement_requestDto);
    RetirementPlanResponseDto getRetirementPlanByEmployeeId(Long employeeId);
}
