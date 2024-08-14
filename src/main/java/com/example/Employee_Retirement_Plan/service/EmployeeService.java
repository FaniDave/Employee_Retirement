package com.example.Employee_Retirement_Plan.service;

import com.example.Employee_Retirement_Plan.dto.EmployeeResponseDto;
import com.example.Employee_Retirement_Plan.dto.EmployeeResponseDtoFormat;
import com.example.Employee_Retirement_Plan.dto.Employee_Retirement_requestDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDtoFormat> getAllEmployees();
    List<EmployeeResponseDtoFormat> getMonthlyUpcomingRetireesEmployees();
}
