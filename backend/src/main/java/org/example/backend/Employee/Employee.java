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
   private String id;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ExecutiveOrEmployee getExecutiveOrEmployee() {
        return executiveOrEmployee;
    }

    public void setExecutiveOrEmployee(ExecutiveOrEmployee executiveOrEmployee) {
        this.executiveOrEmployee = executiveOrEmployee;
    }

    public EmployeeProfession getEmployeeProfession() {
        return employeeProfession;
    }

    public void setEmployeeProfession(EmployeeProfession employeeProfession) {
        this.employeeProfession = employeeProfession;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && executiveOrEmployee == employee.executiveOrEmployee && employeeProfession == employee.employeeProfession && Objects.equals(birthDate, employee.birthDate) && Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, executiveOrEmployee, employeeProfession, birthDate, id);
    }

    public Employee(String firstName, String lastName, ExecutiveOrEmployee executiveOrEmployee, EmployeeProfession employeeProfession, LocalDate birthDate, String id){

       this.firstName = firstName;
       this.lastName = lastName;
       this.executiveOrEmployee = executiveOrEmployee;
       this.employeeProfession = employeeProfession;
       this.birthDate = birthDate;
       this.id = id;
   }

   public Employee(){
   }





   // Hier ist eine potenzielle Fehlerquelle ich muss noch prüfen, ob ein Minus dran ist.
   public long getAge(){
        return ChronoUnit.YEARS.between(birthDate,LocalDate.now() );
   }



}
