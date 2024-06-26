package com.zaroyan.employeeaccountingex.repositories;

import com.zaroyan.employeeaccountingex.models.Employee;
import com.zaroyan.employeeaccountingex.projeections.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zaroyan
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<EmployeeProjection> findAllProjectedBy();
}
