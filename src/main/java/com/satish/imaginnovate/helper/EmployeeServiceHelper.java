package com.satish.imaginnovate.helper;

import com.satish.imaginnovate.dto.EmployeeTaxDTO;
import com.satish.imaginnovate.entity.Employee;
import com.satish.imaginnovate.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Component
public class EmployeeServiceHelper {

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeTaxDTO calculateDeductions(Employee employee) {

        LocalDate financialYearStart = LocalDate.of(LocalDate.now().getYear(), Month.APRIL, 1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate employeeDOJ = LocalDate.parse(employee.getDoj(), formatter);

        if(employeeDOJ.isAfter(financialYearStart)) {
            financialYearStart = employeeDOJ;
        }

        Period period = Period.between(financialYearStart, LocalDate.now());
        int monthsWorked = period.getMonths() + 12 * period.getYears();

        double totalSalary = employee.getSalary() * monthsWorked;
        double tax = calculateTax(totalSalary);
        double cess = calculateCess(totalSalary);

        EmployeeTaxDTO employeeTaxDTO = employeeMapper.getEmployeeTaxDTO(employee);
        employeeTaxDTO.setYearlySalary(totalSalary);
        employeeTaxDTO.setTaxAmount(tax);
        employeeTaxDTO.setCessAmount(cess);

        return employeeTaxDTO;
    }

    private double calculateTax(double salary) {
        if(salary <= 250000) {
            return 0;
        }else if(salary <= 500000) {
            return (salary - 250000) * 0.05;
        }else if(salary <= 1000000) {
            return 12500 + (salary - 500000) * 0.1;
        }else{
            return 112500 + (salary - 1000000) * 0.2;
        }
    }

    private double calculateCess(double salary) {
        if(salary > 2500000) {
            return (salary - 2500000) * 0.02;
        }
        return 0;
    }

}
