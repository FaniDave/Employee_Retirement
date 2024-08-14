package com.example.Employee_Retirement_Plan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Retirement-Plan")
public class RetirementPlan {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long planId;
     @NotBlank
     @Column(unique = true, nullable = false)
      private String referenceNumber;
      @Column(nullable = false)
      @Temporal(TemporalType.DATE)
      private LocalDate enrollmentDate;
      @Column(nullable = false)
      @Temporal(TemporalType.DATE)
      private LocalDate retirementDate;
      @Column(nullable = true)
      private Double monthlyContribution;
      @OneToOne(mappedBy = "retirementPlan")
      private Employee employee;
}
