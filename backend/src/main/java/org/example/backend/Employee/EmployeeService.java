package org.example.backend.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class EmployeeService {
    EmployeeRepo employeeRepo;
    EmployeeIdService employeeIdService;

    public EmployeeService(EmployeeRepo employeeRepo, EmployeeIdService employeeIdService){
        this.employeeRepo = employeeRepo;
        this.employeeIdService = employeeIdService;

    }




    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }

    public Employee addEmployee(EmployeeDTO employeeDTO){
        Employee employeeToAdd = new Employee(employeeDTO.firstName(),employeeDTO.lastName(),employeeDTO.executiveOrEmployee(),employeeDTO.employeeProfession(),employeeDTO.birthDate(), employeeIdService.generateId());
        employeeRepo.save(employeeToAdd);
        return employeeToAdd;

    }

    public Employee updateEmployee(Employee employee, String id){

        Employee employeeToUpdate = new Employee(employee.getFirstName(),employee.getLastName(),employee.getExecutiveOrEmployee(),employee.getEmployeeProfession(),employee.getBirthDate(),id);
        employeeRepo.save(employeeToUpdate);
        return employeeToUpdate;
    }

    public Employee findEmployeeById(String id){

        Employee employeeFindById = employeeRepo.findById(id).orElseThrow(()-> new NoSuchElementException("Todo with id: " + id + "not fund"));
        return employeeFindById;
    }

    public void deleteEmployeeById(String id){

        employeeRepo.deleteById(id);
    }




}
