package com.satish.imaginnovate.service;

import com.satish.imaginnovate.dto.EmployeeDTO;
import com.satish.imaginnovate.dto.EmployeeTaxDTO;
import com.satish.imaginnovate.entity.Employee;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee) throws ValidationException;

    List<Employee> getAllEmployees();

    EmployeeTaxDTO calculateDeductions(Employee employee);
}
