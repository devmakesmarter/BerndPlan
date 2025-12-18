package org.example.backend.Employee;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeIdService {


    public EmployeeIdService(){

    }


    public String generateId(){

        return  UUID.randomUUID().toString();

    }

}
