package com.businessmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.businessmodel.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
