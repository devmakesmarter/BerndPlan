package org.example.backend.Employee;

public enum ExecutiveOrEmployee {
    EXECUTIVE("Executive"),
    EMPLOYEE("Employee");

    private final String value;

    ExecutiveOrEmployee(String value){

        this.value = value;
    }
    public String getValue(){
        return value;
    }

}
