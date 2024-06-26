package com.zaroyan.employeeaccountingex.repositories;

import com.zaroyan.employeeaccountingex.models.Employee;
import com.zaroyan.employeeaccountingex.projeections.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zaroyan
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT CONCAT(e.firstName, ' ', e.lastName) AS fullName, e.position AS position, e.department.name AS departmentName FROM Employee e")
    List<EmployeeProjection> findAllProjectedBy();
}
