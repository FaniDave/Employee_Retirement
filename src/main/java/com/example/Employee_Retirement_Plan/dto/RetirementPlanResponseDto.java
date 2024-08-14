package com.example.Employee_Retirement_Plan.dto;

import com.example.Employee_Retirement_Plan.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RetirementPlanResponseDto {
    private Long planId;
    private String referenceNumber;
    private LocalDate enrollmentDate;
    private LocalDate retirementDate;
    private Double monthlyContribution;
    private EmployeeResponseDto employeeResponse;
}
