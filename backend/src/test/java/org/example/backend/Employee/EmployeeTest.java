package org.example.backend.Employee;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeTest {

    @Test
    void testForSonar(){
        Employee testEmployee = new Employee();
        testEmployee.setFirstName("Ismail");
        testEmployee.setLastName("Ismail");
        testEmployee.setEmployeeProfession(EmployeeProfession.APOTHEKER);
        testEmployee.setExecutiveOrEmployee(ExecutiveOrEmployee.EMPLOYEE);
        testEmployee.setBirthDate(LocalDate.of(1990,01,01));

        assertEquals(35,testEmployee.getAge());
        assertEquals( "Ismail",testEmployee.getFirstName());
        assertEquals("Ismail", testEmployee.getLastName());
        assertEquals(EmployeeProfession.APOTHEKER,testEmployee.getEmployeeProfession());
        assertEquals(ExecutiveOrEmployee.EMPLOYEE,testEmployee.getExecutiveOrEmployee());
        assertEquals(LocalDate.of(1990,01,01), testEmployee.getBirthDate());


    }

}