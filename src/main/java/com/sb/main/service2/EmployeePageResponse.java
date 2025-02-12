package com.sb.main.service2;

import com.sb.main.entity.Employee;
import java.util.List;

public class EmployeePageResponse {
    private List<Employee> employees;
    private int totalRecords;

    
    public EmployeePageResponse() {
    }

    // ✅ Parameterized constructor
    public EmployeePageResponse(List<Employee> employees, int totalRecords) {
        this.employees = employees;
        this.totalRecords = totalRecords;
    }

    // ✅ Getters
    public List<Employee> getEmployees() {
        return employees;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    
    @Override
    public String toString() {
        return "EmployeePageResponse{" +
                "employees=" + employees +
                ", totalRecords=" + totalRecords +
                '}';
    }
}
