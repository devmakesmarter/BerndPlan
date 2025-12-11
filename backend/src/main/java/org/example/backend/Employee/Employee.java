package org.example.backend.Employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Employee {


   private String firstName;
   private String lastName;
   private Integer age;
   private ExecutiveOrEmployee executiveOrEmployee;
   private EmployeeProfession  employeeProfession;
   private LocalDate birthDate;

   public Employee(String firstName, String lastName, ExecutiveOrEmployee executiveOrEmployee, EmployeeProfession employeeProfession, LocalDate birthDate){

       this.firstName = firstName;
       this.lastName = lastName;
       this.executiveOrEmployee = executiveOrEmployee;
       this.employeeProfession = employeeProfession;
       this.birthDate = birthDate;
   }

   public Employee(){
   }
   // Hier ist eine potenzielle Fehlerquelle ich muss noch prüfen, ob ein Minus dran ist.
   public long getAge(){
        return ChronoUnit.YEARS.between(LocalDate.now(), birthDate);
   }

}
