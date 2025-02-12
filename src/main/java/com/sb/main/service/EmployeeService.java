package com.sb.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sb.main.entity.Employee;
import com.sb.main.repo.EmployeeRepository;
import com.sb.main.service2.EmployeePageResponse;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired  
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Page<Employee> getEmployees(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        PageRequest pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findAll(pageable);
    }

    public EmployeePageResponse getEmployees(int page, int size) {
        int offset = page * size;
        List<Employee> employees = employeeRepository.getEmployeesNative(size, offset);
        int totalRecords = employeeRepository.getTotalEmployees();
        
        return new EmployeePageResponse(employees, totalRecords);
    }
}

