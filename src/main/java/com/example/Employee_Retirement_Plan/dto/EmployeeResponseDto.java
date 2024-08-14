package com.example.Employee_Retirement_Plan.dto;

import com.example.Employee_Retirement_Plan.entity.Employee;
import com.example.Employee_Retirement_Plan.entity.RetirementPlan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private Double yearlySalary;
}
