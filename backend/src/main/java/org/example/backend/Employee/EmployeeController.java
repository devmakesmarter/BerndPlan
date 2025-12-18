package org.example.backend.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }




    @GetMapping("/all")
     public List <Employee> getAll (){
       return employeeService.getAll();
    }




    @PostMapping("/add")
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO){

        return  employeeService.addEmployee(employeeDTO);

    }








}
