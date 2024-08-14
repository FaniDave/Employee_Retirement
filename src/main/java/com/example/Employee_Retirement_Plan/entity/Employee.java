package com.example.Employee_Retirement_Plan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long employee_id;
     @Column(nullable = false)
     @NotBlank
     private String firstName;
     @Column(nullable = false)
     @NotBlank
     private String lastName;
     private Double yearlySalary;
     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "retirementPlan_id")
     private RetirementPlan retirementPlan;
}
