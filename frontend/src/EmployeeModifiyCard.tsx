import {type FormEvent, useEffect, useState} from "react";
import axios from "axios";
import type {EmployeeToAddWithId} from "./types/TypeEmployee.ts";
import {useNavigate, useParams} from "react-router-dom";



type EmployeeModifiyProps = {
    getAllEmployees: () => void
}



export default function EmployeeModifiyCard(props: EmployeeModifiyProps){

    const params = useParams()
    const navigate = useNavigate()

    const [firstName, setFirstName] = useState<string>("")
    const [lastName, setLastName] = useState<string>("")
    const [executiveOrEmployee, setExecutiveOrEmployee] = useState<string>("EXECUTIVE")
    const [employeeProfession, setEmployeeProfession] =  useState<string>("APOTHEKER")
    const [birthDate, setBirthDate] = useState<string>("")
    const [id, setId] = useState<string>("")



    const url = params.id
    useEffect(() => {




        axios.get(`/api/${url}`)
            .then((response) => {
                const emp = response.data
                setFirstName(emp.firstName ?? "")
                setLastName(emp.lastName ?? "")
                setExecutiveOrEmployee(emp.executiveOrEmployee ?? "EXECUTIVE")
                setEmployeeProfession(emp.employeeProfession ?? "APOTHEKER")
                setBirthDate(emp.birthDate ?? "")
                setId(emp.id ?? url)
            })
            .catch(console.error)


    },[url])




    function handleSave(event:FormEvent<HTMLFormElement> ){
        event.preventDefault()
        const toPost:EmployeeToAddWithId ={
            firstName,
            lastName,
            executiveOrEmployee,
            employeeProfession,
            birthDate,
            id
        }
        console.log(toPost)
        axios.put(`/api/${id}`,toPost)
            .then(()=> {props.getAllEmployees()})
        console.log("Put ist gemacht")



        //props.getAllEmployees()
        navigate(`/`)
    }

    function handleBack(event: React.MouseEvent<HTMLButtonElement>){
        event.preventDefault()
        navigate(`/`)

    }





    return (
        <>
            <form onSubmit={handleSave} className="bg-gray-400">
                <label> Vorname:
                    <input value={firstName} placeholder={"Bitte Vornmane eintragen"} onChange={(e) => {setFirstName(e.target.value);console.log(firstName);}} />
                </label>
                <label> Nachname:
                    <input value={lastName} placeholder={"Bitte Nachnamen eintragen"} onChange={(e) =>  {setLastName(e.target.value)} }/>
                </label>
                <label> Führungskraft:
                    <select value={executiveOrEmployee} onChange={(e) => setExecutiveOrEmployee(e.target.value)}>
                        <option value={"EXECUTIVE"}>Ja</option>
                        <option value ={"EMPLOYEE"}>Nein</option>
                    </select>
                </label>
                <label> Berufsbezeichnung:
                    <select value={employeeProfession} onChange={(e) => setEmployeeProfession(e.target.value)}>
                        <option value={"APOTHEKER"}>Apotheker</option>
                        <option value ={"PTA"}>Pta</option>
                        <option value={"PKA"}>Pka</option>
                        <option value ={"HILFSKRAFT"}>Hilfskraft</option>
                        <option value ={"AUSZUBILDENDER"}>Auszubildener</option>
                    </select>
                </label>
                <label> Geburtsdatum:
                    <input value={birthDate} type={"date"} min={"1920-01-01"}  placeholder={"tt.mm.jjjj"} onChange={(e) => setBirthDate(e.target.value) } />
                </label>
                <button type={"submit"}  >Speichern</button>
                <button type={"button"} onClick={handleBack}  >Zurück</button>
            </form>

        </>

    )

}