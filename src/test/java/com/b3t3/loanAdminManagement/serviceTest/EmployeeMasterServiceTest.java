package com.b3t3.loanAdminManagement.serviceTest;

import com.b3t3.loanAdminManagement.Exception.IdAlreadyExistsException;
import com.b3t3.loanAdminManagement.Exception.IdDoesNotExistException;
import com.b3t3.loanAdminManagement.dao.Employee_Master_dao;
import com.b3t3.loanAdminManagement.model.Employee_Master;
import com.b3t3.loanAdminManagement.service.Employee_Master_service_impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeMasterServiceTest {
    
	//Class to test the employee service
	
	@Mock
    Employee_Master_dao repository;

    @InjectMocks
    Employee_Master_service_impl employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void addNewEmployee() throws IdAlreadyExistsException {
        Employee_Master newEmployee = new Employee_Master("1987283", "Siddharth", "Gateman", "Security",
                'O', new Date(2000,4,21), new Date(2022,07,25));
        when(repository.findById(anyString())).thenReturn(Optional.of(newEmployee));
        String response = employeeService.addEmployee(newEmployee);
        assert(response.equals("Employee Added Successfully!"));
        Optional<Employee_Master> found = repository.findById(newEmployee.getEmployee_id());
        assert(found.isPresent());
        assert(found.get().getEmployee_id().equals(newEmployee.getEmployee_id()));
    }

    @Test
    public void updateEmployeeCheck(){
        Employee_Master newEmployee = new Employee_Master("1987283", "Siddharth", "Gateman", "Security",
                'O', new Date(2000,4,21), new Date(2022,07,25));
        String response;
        when(repository.findById(anyString())).thenReturn(Optional.of(newEmployee));
        try {
            newEmployee.setDesignation("CEO");
            response = employeeService.updateEmployee(newEmployee);
            assert(response.toLowerCase().contains("updated"));
        }catch (Exception e) {
            assert(e.getMessage().toLowerCase().contains("does not exist"));
        }
    }

    @Test
    public void deleteEmployeeCheck(){
        Employee_Master newEmployee = new Employee_Master("1987283", "Siddharth", "Gateman", "Security",
                'O', new Date(2000,4,21), new Date(2022,07,25));
        String response;
        when(repository.findById(anyString())).thenReturn(Optional.of(newEmployee));
        try {
            response = employeeService.deleteEmployee(newEmployee.getEmployee_id());
            assert(response.toLowerCase().contains("deleted"));
        }catch (Exception e) {
            assert(e.getMessage().toLowerCase().contains("does not exist"));
        }
    }

    @Test
    public void deleteEmployeeWhenDoesNotExist(){
        Employee_Master newEmployee = new Employee_Master("1987283", "Siddharth", "Gateman", "Security",
                'O', new Date(2000,4,21), new Date(2022,07,25));
        when(repository.findById(anyString())).thenReturn(Optional.of(newEmployee));
        assertThrows(IdDoesNotExistException.class, () -> {
            employeeService.deleteEmployee(newEmployee.getEmployee_id());
        });
    }

    @Test
    public void updateEmployeeWhenDoesNotExist(){
        Employee_Master newEmployee = new Employee_Master("1987283", "Siddharth", "Gateman", "Security",
                'O', new Date(2000,4,21), new Date(2022,07,25));
        when(repository.findById(anyString())).thenReturn(Optional.of(newEmployee));
        assertThrows(IdDoesNotExistException.class, () -> {
            employeeService.updateEmployee(newEmployee);
        });
    }
}
