package org.example.backend.Employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeTest {

    @Test
    void testForSonar(){
        Employee testEmployee = new Employee();

        //assertNull(testEmployee.getAge());
        assertNull(testEmployee.getBirthDate());
        assertNull(testEmployee.getEmployeeProfession());
        assertNull(testEmployee.getExecutiveOrEmployee());
        assertNull(testEmployee.getFirstName());
        assertNull(testEmployee.getLastName());

    }

}