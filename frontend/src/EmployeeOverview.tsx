import type {TypeEmployee} from "./types/TypeEmployee.ts";
import  axios from "axios";
import {useEffect, useState} from "react";
import EmployeeCard from "./EmployeeCard.tsx";

import EmployeeAddCard from "./EmployeeAddCard.tsx";
import {useNavigate} from "react-router-dom";

type EmployOverviewProps = {
    employees: TypeEmployee[],
    getAllEmployees: () => void
}

export default function EmployeeOverview(props: EmployOverviewProps){



const navigate = useNavigate()


    return(
        <>
            <div className="mainContianer bg-gray-200">

            <div className="flex gap-4 ">
                {props.employees.map(e => <EmployeeCard reload={props.getAllEmployees} key={e.id} id={e.id} firstName={e.firstName} lastName={e.lastName} age={e.age} executiveOrEmployee={e.executiveOrEmployee} employeeProfession={e.employeeProfession} birthDate={e.birthDate}/>)}
            </div>
                <div>
                    <button onClick={() => navigate("/employeeadd")}>Hinzufügen</button>
                </div>
            </div>



        </>
    )
}