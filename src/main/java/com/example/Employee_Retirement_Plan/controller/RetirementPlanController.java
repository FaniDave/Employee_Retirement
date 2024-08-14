package com.example.Employee_Retirement_Plan.controller;

import com.example.Employee_Retirement_Plan.dto.Employee_Retirement_requestDto;
import com.example.Employee_Retirement_Plan.dto.RetirementPlanResponseDto;
import com.example.Employee_Retirement_Plan.service.RetirementPlanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("empret/api/v1/retirementPlan")
public class RetirementPlanController {
     @Autowired
    private RetirementPlanService retirementPlanService;

     @PostMapping("/new")
     public ResponseEntity<RetirementPlanResponseDto> createRetirementPlan(@RequestBody @Valid Employee_Retirement_requestDto employee_retirement_requestDto) {
         RetirementPlanResponseDto retirementPlanResponseDto = retirementPlanService.save(employee_retirement_requestDto);
         return new ResponseEntity<>(retirementPlanResponseDto, HttpStatus.OK);
     }

     @GetMapping("/emp/{employeeId}")
     public ResponseEntity<RetirementPlanResponseDto> getRetirementPlanByEmployeeId(@PathVariable Long employeeId) {
           RetirementPlanResponseDto retirementPlanResponseDto = retirementPlanService.getRetirementPlanByEmployeeId(employeeId);
           return new ResponseEntity<>(retirementPlanResponseDto, HttpStatus.OK);
     }
}
