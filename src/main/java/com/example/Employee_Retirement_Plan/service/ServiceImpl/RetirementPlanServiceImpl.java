package com.example.Employee_Retirement_Plan.service.ServiceImpl;

import com.example.Employee_Retirement_Plan.dto.Employee_Retirement_requestDto;
import com.example.Employee_Retirement_Plan.dto.RetirementPlanResponseDto;
import com.example.Employee_Retirement_Plan.entity.Employee;
import com.example.Employee_Retirement_Plan.entity.RetirementPlan;
import com.example.Employee_Retirement_Plan.exception.ResourceNotFoundException;
import com.example.Employee_Retirement_Plan.mapper.ClassMapper;
import com.example.Employee_Retirement_Plan.repository.EmployeeRepository;
import com.example.Employee_Retirement_Plan.repository.RetirementPlanRepository;
import com.example.Employee_Retirement_Plan.service.RetirementPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class RetirementPlanServiceImpl implements RetirementPlanService {

       @Autowired
       private RetirementPlanRepository retirementPlanRepository;
       @Autowired
       private EmployeeRepository employeeRepository;

       @Override
       public RetirementPlanResponseDto save(Employee_Retirement_requestDto employee_retirement_requestDto) {
           RetirementPlan retirementPlan = ClassMapper.request_To_RetirementPlan(employee_retirement_requestDto);
           retirementPlanRepository.save(retirementPlan);
           Employee employee = ClassMapper.request_To_Employee(employee_retirement_requestDto);
           employee.setRetirementPlan(retirementPlan);
           employeeRepository.save(employee);
           return ClassMapper.retirementPlan_To_RetirementPlanResponseDto(retirementPlan, employee);
       }

       @Override
       public RetirementPlanResponseDto getRetirementPlanByEmployeeId(Long employeeId) throws ResourceNotFoundException {
             RetirementPlan retirementPlan = retirementPlanRepository.findRetirementPlanByEmployeeEmployee_id(employeeId);
             if(retirementPlan == null) {
                 throw new ResourceNotFoundException("Employee Not Found");
             }
             Employee employee = retirementPlan.getEmployee();
             return ClassMapper.retirementPlan_To_RetirementPlanResponseDto(retirementPlan, employee);
       }
}
