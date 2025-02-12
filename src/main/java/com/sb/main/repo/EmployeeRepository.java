package com.sb.main.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sb.main.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

   
    @Query(value = "SELECT * FROM employees ORDER BY id ASC LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Employee> getEmployeesNative(@Param("limit") int limit, @Param("offset") int offset);

    @Query(value = "SELECT COUNT(*) FROM employees", nativeQuery = true)
    int getTotalEmployees();
}
