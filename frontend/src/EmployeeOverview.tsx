import type {TypeEmployee} from "./types/TypeEmployee.ts";
import  axios from "axios";
import {useEffect, useState} from "react";
import EmployeeCard from "./EmployeeCard.tsx";

import EmployeeAddCard from "./EmployeeAddCard.tsx";



export default function EmployeeOverview(){

    const [employees, setEmployees] = useState<TypeEmployee[]>([])

    function getAllEmployees(){
        axios.get("/api/all")
            .then(response => {setEmployees(response.data)
                console.log("Anfrage ist raus ")})
    }

    useEffect(()=>{
        getAllEmployees()

    },[])

    return(
        <>
            <div className="mainContianer bg-amber-300">
            <form>Searchbar </form>
            <div className="flex gap-4 ">
                {employees.map(e => <EmployeeCard key={e.id} id={e.id} firstName={e.firstName} lastName={e.lastName} age={e.age} executiveOrEmployee={e.executiveOrEmployee} employeeProfession={e.employeeProfession} birthDate={e.birthDate}/>)}
            </div>
            <div>
               <EmployeeAddCard/>
            </div>
            </div>
        </>
    )
}