package org.example.backend.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


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

    @PutMapping("{id}")
    public Employee putEmployee(@RequestBody Employee employee, @PathVariable String id) {

        return employeeService.updateEmployee(employee,id);
    }

    @GetMapping("{id}")
    public ResponseEntity <Employee> getEmployeeById(@PathVariable String id){
        try{
            Employee employee = employeeService.findEmployeeById(id);
            return ResponseEntity.ok(employee);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();

        }



    }










}
