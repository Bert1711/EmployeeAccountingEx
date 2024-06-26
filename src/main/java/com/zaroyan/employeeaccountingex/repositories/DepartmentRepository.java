package com.zaroyan.employeeaccountingex.repositories;

import com.zaroyan.employeeaccountingex.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zaroyan
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
