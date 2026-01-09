package org.example.backend.Employee;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Test
    void getAll_shouldReturnAllEmployees_whenCalledWithValidData() {
       //Given
       EmployeeRepo mockTestRepo = mock(EmployeeRepo.class);
       EmployeeIdService mockTestIdService = mock(EmployeeIdService.class);
       EmployeeService testEmployeeService = new EmployeeService(mockTestRepo,mockTestIdService);
       List<Employee> testEmployees = new ArrayList<Employee>();
       Employee testEmployeeOne = new Employee("Klaus", "Testmensch", ExecutiveOrEmployee.EMPLOYEE, EmployeeProfession.PTA, LocalDate.of(1995,2,1),"1");
       Employee testEmployeeTwo = new Employee("Sonja", "Testmensch", ExecutiveOrEmployee.EXECUTIVE,EmployeeProfession.APOTHEKER, LocalDate.of(1998,2,1),"2");
       testEmployees.add(testEmployeeOne);
       testEmployees.add(testEmployeeTwo);

       //When
       when(mockTestRepo.findAll()).thenReturn(testEmployees);
       List<Employee> actual = testEmployeeService.getAll();
       //Then
       assertEquals(testEmployees,actual);

    }

    @Test
    void addEmployee_shouldReturnTheEmployeeAdded(){
        EmployeeRepo mockTestRepo = mock(EmployeeRepo.class);
        EmployeeIdService mockTestIdService = mock(EmployeeIdService.class);
        EmployeeService testEmployeeService = new EmployeeService(mockTestRepo,mockTestIdService);
        Employee testEmployeeOne = new Employee("Klaus", "Testmensch", ExecutiveOrEmployee.EMPLOYEE, EmployeeProfession.PTA, LocalDate.of(1995,2,1),"1");
        EmployeeDTO testEmployeeDtoOne = new EmployeeDTO("Klaus", "Testmensch", ExecutiveOrEmployee.EMPLOYEE, EmployeeProfession.PTA, LocalDate.of(1995,2,1));

        when(mockTestIdService.generateId()).thenReturn("1");

        when(mockTestRepo.save(testEmployeeOne)).thenReturn(testEmployeeOne);
        Employee actual = testEmployeeService.addEmployee(testEmployeeDtoOne);

        assertEquals(testEmployeeOne,actual);

    }


    @Test
    void updateEmployee_ShouldReturnEmployee_WhenCalledWithEmployeeAndId(){
        EmployeeRepo mockTestRepo = mock(EmployeeRepo.class);
        EmployeeIdService mockTestIdService = mock(EmployeeIdService.class);
        EmployeeService testEmployeeService = new EmployeeService(mockTestRepo,mockTestIdService);
        Employee testEmployeeOne = new Employee("Klaus", "Testmensch", ExecutiveOrEmployee.EMPLOYEE, EmployeeProfession.PTA, LocalDate.of(1995,2,1),"1");
        String id = "1";
        when(mockTestRepo.save(testEmployeeOne)).thenReturn(testEmployeeOne);

        Employee actual = testEmployeeService.updateEmployee(testEmployeeOne,id);

        assertEquals(testEmployeeOne,actual);




    }



    @Test
    void findEmployeeById_withValidId_shouldReturnEmployee(){

        //GIVEN
        EmployeeRepo mockTestRepo = mock(EmployeeRepo.class);
        EmployeeIdService mockTestIdService = mock(EmployeeIdService.class);
        EmployeeService testEmployeeService = new EmployeeService(mockTestRepo, mockTestIdService);
        String id = "1";
        Employee testEmployeeOne = new Employee("Klaus", "Testmensch", ExecutiveOrEmployee.EMPLOYEE, EmployeeProfession.PTA, LocalDate.of(1995,2,1),"1");
        when(mockTestRepo.findById(id)).thenReturn(Optional.ofNullable(testEmployeeOne));

        //WHEN

        Employee actual = testEmployeeService.findEmployeeById(id);

        //THEN

        verify(mockTestRepo).findById(id);
        assertEquals(testEmployeeOne,actual);

    }

    @Test
    void findEmployeeById_withWrongId_shouldThrowException(){
        EmployeeRepo mockTestRepo = mock(EmployeeRepo.class);
        EmployeeIdService mockTestIdService = mock(EmployeeIdService.class);
        EmployeeService testEmployeeService = new EmployeeService(mockTestRepo, mockTestIdService);
        String id = "1";
        Employee testEmployeeOne = new Employee("Klaus", "Testmensch", ExecutiveOrEmployee.EMPLOYEE, EmployeeProfession.PTA, LocalDate.of(1995,2,1),"1");
        when(mockTestRepo.findById(id)).thenReturn(Optional.empty());

        //WHEN
        assertThrows(NoSuchElementException.class,()-> testEmployeeService.findEmployeeById(id));


        //THEN

        verify(mockTestRepo).findById(id);


    }







}