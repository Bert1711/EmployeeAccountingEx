package com.zaroyan.employeeaccountingex.services;

import com.zaroyan.employeeaccountingex.models.Employee;
import com.zaroyan.employeeaccountingex.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("Bert");
        employee.setLastName("Zrn");
    }

    @Test
    void testGetEmployeeById() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        Employee foundEmployee = employeeService.getEmployeeById(1L);

        assertNotNull(foundEmployee);
        assertEquals("Bert", foundEmployee.getFirstName());

        verify(employeeRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateEmployee() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee updatedEmployee = employeeService.updateEmployee(1L, employee);

        assertNotNull(updatedEmployee);
        assertEquals("Bert", updatedEmployee.getFirstName()); // Assuming no update to firstName

        verify(employeeRepository, times(1)).findById(1L);
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void testDeleteEmployee() {
        doNothing().when(employeeRepository).deleteById(1L);

        employeeService.deleteEmployee(1L);

        verify(employeeRepository, times(1)).deleteById(1L);
    }
}
