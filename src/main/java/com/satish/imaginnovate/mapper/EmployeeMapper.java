package com.satish.imaginnovate.mapper;

import com.satish.imaginnovate.dto.EmployeeDTO;
import com.satish.imaginnovate.dto.EmployeeTaxDTO;
import com.satish.imaginnovate.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDTO getEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setPhoneNumbers(employee.getPhoneNumbers());
        employeeDTO.setDoj(employee.getDoj());
        employeeDTO.setSalary(employee.getSalary());

        return employeeDTO;
    }

    public Employee getEmployee(EmployeeDTO dto){
        Employee employee = new Employee();

        employee.setEmployeeId(dto.getEmployeeId());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setPhoneNumbers(dto.getPhoneNumbers());
        employee.setDoj(dto.getDoj());
        employee.setSalary(dto.getSalary());

        return employee;
    }

    public EmployeeTaxDTO getEmployeeTaxDTO(Employee employee){
        EmployeeTaxDTO employeeTaxDTO = new EmployeeTaxDTO();

        employeeTaxDTO.setEmployeeId(employee.getEmployeeId());
        employeeTaxDTO.setFirstName(employee.getFirstName());
        employeeTaxDTO.setLastName(employee.getLastName());

        return employeeTaxDTO;
    }

}
