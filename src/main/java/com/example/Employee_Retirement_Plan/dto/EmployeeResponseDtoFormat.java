package com.example.Employee_Retirement_Plan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseStatus;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeResponseDtoFormat {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private Double yearlySalary;
    private RetirementPlanResponseDtoFormat retirementPlanResponse;
}
