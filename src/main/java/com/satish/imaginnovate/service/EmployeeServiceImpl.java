package com.satish.imaginnovate.service;

import com.satish.imaginnovate.dto.EmployeeTaxDTO;
import com.satish.imaginnovate.entity.Employee;
import com.satish.imaginnovate.helper.EmployeeServiceHelper;
import com.satish.imaginnovate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeServiceHelper employeeServiceHelper;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        ArrayList<Employee> employeeList = new ArrayList<>(employeeRepository.findAll());
        return employeeList;
    }

    @Override
    public EmployeeTaxDTO calculateDeductions(Employee employee){
        return employeeServiceHelper.calculateDeductions(employee);
    }

}
