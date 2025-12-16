import type {TypeEmployee} from "./types/TypeEmployee.ts";
import employeeImage from "./assets/pictureForEmployee.jpg";

export default function EmployeeCard(props: TypeEmployee){


        return(
            <>
                <div className="bg-gray-400 w-60 p-2 bg-gray-400 rounded-lg" >
                    <div className="img_for_employee bg-blue-500">
                        <img src={employeeImage}  />
                    </div>
                    <div className="Employee_details">
                        <div className="flex  justify-between">
                            <h5>{props.firstName} {props.lastName}</h5>
                            <p>{props.age}</p>
                        </div>
                        <h5>{props.employeeProfession} - {props.executiveOrEmployee}</h5>
                    </div>

                </div>


            </>
        )




}