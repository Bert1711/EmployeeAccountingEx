package com.zaroyan.employeeaccountingex.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zaroyan
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
