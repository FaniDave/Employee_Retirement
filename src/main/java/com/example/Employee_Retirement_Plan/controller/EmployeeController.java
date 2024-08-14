package com.example.Employee_Retirement_Plan.controller;

import com.example.Employee_Retirement_Plan.dto.EmployeeResponseDto;
import com.example.Employee_Retirement_Plan.dto.EmployeeResponseDtoFormat;
import com.example.Employee_Retirement_Plan.dto.Employee_Retirement_requestDto;
import com.example.Employee_Retirement_Plan.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empret/api/v1/employee/list")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

       @GetMapping
       public ResponseEntity<List<EmployeeResponseDtoFormat>> getAllEmployees() {
           List<EmployeeResponseDtoFormat> employeeResponseDtos = employeeService.getAllEmployees();
           return new ResponseEntity<>(employeeResponseDtos, HttpStatus.OK);
       }

       @GetMapping("/MonthlyUpcomingRetirees")
       public ResponseEntity<List<EmployeeResponseDtoFormat>> getMonthlyUpcomingRetireesEmployees() {
           List<EmployeeResponseDtoFormat> employeeResponseDtoFormats = employeeService.getMonthlyUpcomingRetireesEmployees();
           return new ResponseEntity<>(employeeResponseDtoFormats, HttpStatus.OK);
       }
}
