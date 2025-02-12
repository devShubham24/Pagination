package com.sb.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.sb.main.entity.Employee;
import com.sb.main.service.EmployeeService;
import com.sb.main.service2.EmployeePageResponse;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired  
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{page}/{size}/{sortBy}/{sortDir}")
    public Page<Employee> getEmployees(
            @PathVariable int page,       
            @PathVariable int size,      
            @PathVariable String sortBy,  
            @PathVariable String sortDir  
    ) {
        return employeeService.getEmployees(page, size, sortBy, sortDir);
    }

    @GetMapping("/{page}/{size}")
    public EmployeePageResponse getEmployees(
            @PathVariable int page,
            @PathVariable int size
    ) {
        return employeeService.getEmployees(page, size);
    }
}

