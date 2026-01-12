import type {TypeEmployee} from "./types/TypeEmployee.ts";
import employeeImage from "./assets/pictureForEmployee.jpg";
import {useState} from "react";
import axios from "axios";

type EmployeeCardProps = TypeEmployee & {
    reload: () => void;
};



export default function EmployeeCard(props: EmployeeCardProps){


    function handleDelete(){
        const id = props.id
        axios.delete(`/api/${id}`)
            .then(()=> window.alert(`${id}`))

    }



        return(
            <>
                <div className=" w-60 p-2 bg-gray-400 rounded-lg" >
                    <div className="img_for_employee bg-blue-500">
                        <img src={employeeImage}  />
                    </div>
                    <div className="Employee_details">
                        <div className="flex  justify-between">
                            <h5>{props.firstName} {props.lastName}</h5>
                            <p>{props.age}</p>
                        </div>
                        <h5>{props.employeeProfession} - {props.executiveOrEmployee}</h5>
                        <button>Bearbeiten</button>
                        <button onClick={handleDelete} id={props.id}> Löschen</button>
                    </div>

                </div>


            </>
        )




}