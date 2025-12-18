package org.example.backend.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class EmployeeService {
    EmployeeRepo employeeRepo;
    EmployeeIdService employeeIdService;

    public EmployeeService(EmployeeRepo employeeRepo, EmployeeIdService employeeIdService){
        this.employeeRepo = employeeRepo;
        this.employeeIdService = employeeIdService;
        /*
        Employee testEmployeeOne = new Employee("Martin", "Mensch", ExecutiveOrEmployee.EMPLOYEE, EmployeeProfession.PTA, LocalDate.of(1995,2,1), employeeIdService.generateId());
        Employee testEmployeeTwo = new Employee("Martina", "Mensch", ExecutiveOrEmployee.EXECUTIVE,EmployeeProfession.APOTHEKER, LocalDate.of(1998,2,1), employeeIdService.generateId());
        employeeRepo.save(testEmployeeOne);
        employeeRepo.save(testEmployeeTwo);
        */
    }




    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }

    public Employee addEmployee(EmployeeDTO employeeDTO){
        Employee employeeToAdd = new Employee(employeeDTO.firstName(),employeeDTO.lastName(),employeeDTO.executiveOrEmployee(),employeeDTO.employeeProfession(),employeeDTO.birthDate(), employeeIdService.generateId());
        employeeRepo.save(employeeToAdd);
        return employeeToAdd;

    }




}
