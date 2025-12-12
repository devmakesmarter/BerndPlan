type executiveOrEmployee = "EXECUTIVE" | "EMPLOYEE"

type employeeProfession = "APOTHEKER" | "PTA" | "PKA" | "HILFSKRAFT" | "AUSZUBILDENDER"


 export type TypeEmployee = {
    firstName: string,
    lastName: string,
    age: number,
    executiveOrEmployee: executiveOrEmployee,
    employeeProfession: employeeProfession,
    birthDate: string

}