import type {TypeEmployee} from "./types/TypeEmployee.ts";

export default function EmployeeCard(props: TypeEmployee){

        return(
            <>
            <div>{props.firstName}</div>
            <div>{props.lastName}</div>
            <div>{props.birthDate}</div>
            <div>{props.age}</div>
            <div>{props.employeeProfession}</div>
            <div>{props.executiveOrEmployee}</div>

            </>
        )


}