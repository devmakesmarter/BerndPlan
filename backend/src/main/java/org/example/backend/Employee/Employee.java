package org.example.backend.Employee;

import java.util.Objects;

public class Employee {


   private String firstName;
   private String lastName;
   private Integer age;
   private ExecutiveOrEmployee executiveOrEmployee;
   private EmployeeProfession  employeeProfession;

   public Employee(String firstName, String lastName, Integer age, ExecutiveOrEmployee executiveOrEmployee, EmployeeProfession employeeProfession){
       this.firstName = firstName;
       this.lastName = lastName;
       this.age = age;
       this.executiveOrEmployee = executiveOrEmployee;
       this.employeeProfession = employeeProfession;

   }

   public Employee(){
   }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public ExecutiveOrEmployee getExecutiveOrEmployee() {
        return executiveOrEmployee;
    }

    public EmployeeProfession getEmployeeProfession() {
        return employeeProfession;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setExecutiveOrEmployee(ExecutiveOrEmployee executiveOrEmployee) {
        this.executiveOrEmployee = executiveOrEmployee;
    }

    public void setEmployeeProfession(EmployeeProfession employeeProfession) {
        this.employeeProfession = employeeProfession;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(age, employee.age) && executiveOrEmployee == employee.executiveOrEmployee && employeeProfession == employee.employeeProfession;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, executiveOrEmployee, employeeProfession);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", executiveOrEmployee=" + executiveOrEmployee +
                ", employeeProfession=" + employeeProfession +
                '}';
    }
}
