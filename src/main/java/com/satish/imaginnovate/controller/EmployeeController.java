package com.satish.imaginnovate.controller;

import com.satish.imaginnovate.dto.EmployeeDTO;
import com.satish.imaginnovate.dto.EmployeeTaxDTO;
import com.satish.imaginnovate.entity.Employee;
import com.satish.imaginnovate.mapper.EmployeeMapper;
import com.satish.imaginnovate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @PostMapping("/Employee")
    public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws ValidationException {
        Employee employee = employeeMapper.getEmployee(employeeDTO);
        Employee newEmployee = employeeService.addEmployee(employee);
        EmployeeDTO newEmployeeDTO = employeeMapper.getEmployeeDTO(newEmployee);

        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployeeDTO);
    }

    @GetMapping("/allEmployees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<Employee> employeeList = employeeService.getAllEmployees();
        List<EmployeeDTO> employeeDTOList =new ArrayList<>();

        for(Employee entity:employeeList){
            employeeDTOList.add(employeeMapper.getEmployeeDTO(entity));
        }
        return ResponseEntity.status(HttpStatus.OK).body(employeeDTOList);
    }

    @GetMapping("/employees-taxdeduction")
    public ResponseEntity<List<EmployeeTaxDTO>> getTaxDeductions() {
        List<Employee> employeeList = employeeService.getAllEmployees();

        List<EmployeeTaxDTO> deductions = new ArrayList<>();
        for (Employee employee : employeeList) {
            deductions.add(employeeService.calculateDeductions(employee));
        }

        return ResponseEntity.status(HttpStatus.OK).body(deductions);
    }

}
