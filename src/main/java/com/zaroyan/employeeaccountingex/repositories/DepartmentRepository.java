package com.zaroyan.employeeaccountingex.repositories;

import com.zaroyan.employeeaccountingex.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zaroyan
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
