package org.example.backend.Employee;

import java.time.LocalDate;

public record EmployeeDTO(String firstName,String lastName,ExecutiveOrEmployee executiveOrEmployee,EmployeeProfession  employeeProfession,LocalDate birthDate) {

}
