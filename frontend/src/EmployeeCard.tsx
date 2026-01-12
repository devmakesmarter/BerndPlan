import type {TypeEmployee} from "./types/TypeEmployee.ts";
import employeeImage from "./assets/pictureForEmployee.jpg";

import axios from "axios";
import {useNavigate} from "react-router-dom";

type EmployeeCardProps = TypeEmployee & {
    reload: () => void;
};


export default function EmployeeCard(props: EmployeeCardProps){
    const id = props.id
    const navigate = useNavigate()



    function handleDelete(){

        axios.delete(`/api/${id}`)
            .then(() => {props.reload()})
    }

    function handleToGiveId(){
        navigate(`/detail/${id}`)

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
                        <button onClick={handleToGiveId} id={id} >Bearbeiten</button>
                        <button onClick={handleDelete} id={props.id}> Löschen</button>
                    </div>

                </div>


            </>
        )




}