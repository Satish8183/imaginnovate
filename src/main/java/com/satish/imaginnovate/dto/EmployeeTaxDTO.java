package com.satish.imaginnovate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EmployeeTaxDTO {

    private Long employeeId;

    private String firstName;

    private String lastName;

    private double yearlySalary;

    private double taxAmount;

    private double cessAmount;

}
