package com.satish.imaginnovate.repository;

import com.satish.imaginnovate.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
