type executiveOrEmployee = "EXECUTIVE" | "EMPLOYEE"

type employeeProfession = "APOTHEKER" | "PTA" | "PKA" | "HILFSKRAFT" | "AUSZUBILDENDER"


 export type TypeEmployee = {
    firstName: string,
    lastName: string,
    age: number,
    executiveOrEmployee: executiveOrEmployee,
    employeeProfession: employeeProfession,
    birthDate: string
    id: string

}

export type EmployeeToAdd ={
    firstName: string,
    lastName: string,
    executiveOrEmployee: string,
    employeeProfession: string,
    birthDate: string
}

export type EmployeeToAddWithId ={
    firstName: string,
    lastName: string,
    executiveOrEmployee: string,
    employeeProfession: string,
    birthDate: string,
    id:string
}