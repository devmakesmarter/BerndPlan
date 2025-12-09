package org.example.backend.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class EmployeeService {
    EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;

        Employee testEmployeeOne = new Employee("Martin", "Mensch", 31,ExecutiveOrEmployee.EMPLOYEE, EmployeeProfession.PTA, LocalDate.of(1995,2,1));
        Employee testEmployeeTwo = new Employee("Martina", "Mensch", 28,ExecutiveOrEmployee.EXECUTIVE,EmployeeProfession.APOTHEKER, LocalDate.of(1998,2,1));
        employeeRepo.save(testEmployeeOne);
        employeeRepo.save(testEmployeeTwo);

    }



    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }


}
