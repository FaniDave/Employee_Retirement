package com.example.Employee_Retirement_Plan.service.ServiceImpl;

import com.example.Employee_Retirement_Plan.dto.EmployeeResponseDto;
import com.example.Employee_Retirement_Plan.dto.EmployeeResponseDtoFormat;
import com.example.Employee_Retirement_Plan.dto.Employee_Retirement_requestDto;
import com.example.Employee_Retirement_Plan.entity.Employee;
import com.example.Employee_Retirement_Plan.entity.RetirementPlan;
import com.example.Employee_Retirement_Plan.mapper.ClassMapper;
import com.example.Employee_Retirement_Plan.repository.EmployeeRepository;
import com.example.Employee_Retirement_Plan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeResponseDtoFormat> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        for (int i = 0; i < employees.size(); i++) {
            for (int j = 0; j < employees.size(); j++) {
                if (employees.get(i).getLastName().compareTo(employees.get(j).getLastName()) > 0 && i < j) {
                    Employee temp = employees.get(i);
                    employees.set(i, employees.get(j));
                    employees.set(j, temp);
                }
            }
        }

        List<EmployeeResponseDtoFormat> employeeResponseDtoFormats = new ArrayList<>();
        for (Employee employee : employees) {
            RetirementPlan retirementPlan = employee.getRetirementPlan();
            EmployeeResponseDtoFormat employeeResponseDtoFormat = ClassMapper.employee_To_EmployeeResponseDtoFormat(employee, retirementPlan);
            employeeResponseDtoFormats.add(employeeResponseDtoFormat);
        }
        return employeeResponseDtoFormats;
    }

       @Override
       public List<EmployeeResponseDtoFormat> getMonthlyUpcomingRetireesEmployees() {
              LocalDate nextMonthStart = LocalDate.now().plusMonths(1).withDayOfMonth(1);
              LocalDate nextMonthEnd = nextMonthStart.withDayOfMonth(nextMonthStart.lengthOfMonth());

              // Fetch employees with retirement date within the next month
              List<Employee> upcomingRetirees = employeeRepository.findByRetirementPlan_RetirementDateBetween(nextMonthStart, nextMonthEnd);

              // Map to DTO and sort by retirement date
              return upcomingRetirees.stream()
                      .map(e -> ClassMapper.employee_To_EmployeeResponseDtoFormat(e, e.getRetirementPlan()))
                      .sorted(Comparator.comparing(e -> e.getRetirementPlanResponse().getRetirementDate()))
                      .collect(Collectors.toList());
       }

}
