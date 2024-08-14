package com.example.Employee_Retirement_Plan.mapper;

import com.example.Employee_Retirement_Plan.dto.*;
import com.example.Employee_Retirement_Plan.entity.Employee;
import com.example.Employee_Retirement_Plan.entity.RetirementPlan;

public class ClassMapper {

      public static Employee request_To_Employee (Employee_Retirement_requestDto employee_retirement_requestDto) {
          Employee employee = new Employee();
          employee.setFirstName(employee_retirement_requestDto.getFirstName());
          employee.setLastName(employee_retirement_requestDto.getLastName());
          employee.setYearlySalary(employee_retirement_requestDto.getYearlySalary());
          return employee;
      }

      public static EmployeeResponseDtoFormat employee_To_EmployeeResponseDtoFormat (Employee employee, RetirementPlan retirementPlan) {
                EmployeeResponseDtoFormat employeeResponseDtoFormat = new EmployeeResponseDtoFormat();
                employeeResponseDtoFormat.setEmployeeId(employee.getEmployee_id());
                employeeResponseDtoFormat.setFirstName(employee.getFirstName());
                employeeResponseDtoFormat.setLastName(employee.getLastName());
                employeeResponseDtoFormat.setYearlySalary(employee.getYearlySalary());

                RetirementPlanResponseDtoFormat retirementPlanResponseDto = new RetirementPlanResponseDtoFormat();
                retirementPlanResponseDto.setPlanId(retirementPlan.getPlanId());
                retirementPlanResponseDto.setReferenceNumber(retirementPlan.getReferenceNumber());
                retirementPlanResponseDto.setRetirementDate(retirementPlan.getRetirementDate());
                retirementPlanResponseDto.setEnrollmentDate(retirementPlan.getEnrollmentDate());
                retirementPlanResponseDto.setMonthlyContribution(retirementPlan.getMonthlyContribution());

                employeeResponseDtoFormat.setRetirementPlanResponse(retirementPlanResponseDto);
                return employeeResponseDtoFormat;
      }

      public static RetirementPlan request_To_RetirementPlan (Employee_Retirement_requestDto employee_retirement_requestDto) {
           RetirementPlan retirementPlan = new RetirementPlan();
           retirementPlan.setReferenceNumber(employee_retirement_requestDto.getReferenceNumber());
           retirementPlan.setEnrollmentDate(employee_retirement_requestDto.getEnrollmentDate());
           retirementPlan.setRetirementDate(employee_retirement_requestDto.getRetirementDate());
           if(employee_retirement_requestDto.getRetirementDate() == null){
               retirementPlan.setMonthlyContribution(null);
           }
           retirementPlan.setMonthlyContribution(employee_retirement_requestDto.getMonthlyContribution());
           return retirementPlan;
      }

      public static RetirementPlanResponseDto retirementPlan_To_RetirementPlanResponseDto (RetirementPlan retirementPlan, Employee employee) {
          RetirementPlanResponseDto retirementPlanResponse = new RetirementPlanResponseDto();
          retirementPlanResponse.setPlanId(retirementPlan.getPlanId());
          retirementPlanResponse.setReferenceNumber(retirementPlan.getReferenceNumber());
          retirementPlanResponse.setEnrollmentDate(retirementPlan.getEnrollmentDate());
          retirementPlanResponse.setRetirementDate(retirementPlan.getRetirementDate());
          retirementPlanResponse.setMonthlyContribution(retirementPlan.getMonthlyContribution());

          EmployeeResponseDto employeeResponse = new EmployeeResponseDto();
          employeeResponse.setEmployeeId(employee.getEmployee_id());
          employeeResponse.setFirstName(employee.getFirstName());
          employeeResponse.setLastName(employee.getLastName());
          employeeResponse.setYearlySalary(employee.getYearlySalary());

          retirementPlanResponse.setEmployeeResponse(employeeResponse);

           return retirementPlanResponse;
      }
}
