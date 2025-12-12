package org.example.backend.Employee;

public enum EmployeeProfession {
    APOTHEKER("Apotheker"),
    PTA("PTA"),
    PKA("PKA"),
    HILFSKRAFT("Hilfskraft"),
    AUSZUBILDENDER("Auszubildender");

    private final String value;

    EmployeeProfession(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
