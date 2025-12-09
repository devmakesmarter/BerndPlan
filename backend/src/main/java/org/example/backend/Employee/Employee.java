package org.example.backend.Employee;

public class Employee {


   private String firstName;
   private String lastName;
   private Integer age;

   public Employee(String firstName, String lastName, Integer age){
       this.firstName = firstName;
       this.lastName = lastName;
       this.age = age;
   }

   public Employee(){

   }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }
}
