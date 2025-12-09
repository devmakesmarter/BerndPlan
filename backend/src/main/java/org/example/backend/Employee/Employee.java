package org.example.backend.Employee;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {


   private String firstName;
   private String lastName;
   private Integer age;
   private ExecutiveOrEmployee executiveOrEmployee;
   private EmployeeProfession  employeeProfession;
   private LocalDate birthDate;

   public Employee(String firstName, String lastName, Integer age, ExecutiveOrEmployee executiveOrEmployee, EmployeeProfession employeeProfession, LocalDate birthDate){
       this.firstName = firstName;
       this.lastName = lastName;
       this.age = age;
       this.executiveOrEmployee = executiveOrEmployee;
       this.employeeProfession = employeeProfession;
       this.birthDate = birthDate;

   }

   public Employee(){
   }



}
