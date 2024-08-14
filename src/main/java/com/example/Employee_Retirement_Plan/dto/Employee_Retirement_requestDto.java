package com.example.Employee_Retirement_Plan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee_Retirement_requestDto {
    private String firstName;
    private String lastName;
    private Double yearlySalary;
    private String referenceNumber;
    private LocalDate enrollmentDate;
    private LocalDate retirementDate;
    private Double monthlyContribution;
}
