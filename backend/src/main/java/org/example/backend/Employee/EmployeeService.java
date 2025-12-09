package org.example.backend.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
        /*
        Employee testEmployeeOne = new Employee("Martin", "Mensch", 30,ExecutiveOrEmployee.EMPLOYEE, EmployeeProfession.PTA);
        Employee testEmployeeTwo = new Employee("Martina", "Mensch", 28,ExecutiveOrEmployee.EXECUTIVE,EmployeeProfession.APOTHEKER);
        employeeRepo.save(testEmployeeOne);
        employeeRepo.save(testEmployeeTwo);
        */

    }



    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }


}
