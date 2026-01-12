import {type FormEvent, useState} from "react";
import axios from "axios";
import type {EmployeeToAdd} from "./types/TypeEmployee.ts";

export default function EmployeeAddCard(){

    const [firstName, setFirstName] = useState<string>("")
    const [lastName, setLastName] = useState<string>("")
    const [executiveOrEmployee, setExecutiveOrEmployee] = useState<string>("EXECUTIVE")
    const [employeeProfession, setEmployeeProfession] =  useState<string>("APOTHEKER")
    const [employeeToAdd, setEmployeeToAdd] = useState<EmployeeToAdd>()
    const [birthDate, setBirthDate] = useState<string>("")


    function handleSubmit(event:FormEvent<HTMLFormElement> ){
        event.preventDefault()
        const toPost:EmployeeToAdd ={
            firstName,
            lastName,
            executiveOrEmployee,
            employeeProfession,
            birthDate
        }
        console.log(toPost)
        axios.post("/api/add", toPost)
        window.alert(`Folgendes Objekt wurde gespeichert:/n${JSON.stringify(toPost,null,2)}`)
    }



    return (
        <>
            <form onSubmit={handleSubmit} className="bg-gray-400">
                <label> Vorname:
                    <input placeholder={"Bitte Vornmane eintragen"} onChange={(e) => {setFirstName(e.target.value);console.log(firstName);}} />
                </label>
                <label> Nachname:
                    <input placeholder={"Bitte Nachnamen eintragen"} onChange={(e) =>  {setLastName(e.target.value)} }/>
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
                    <input type={"date"} min={"1920-01-01"}  placeholder={"tt.mm.jjjj"} onChange={(e) => setBirthDate(e.target.value) } />
                </label>
                <button type={"submit"} onClick={handleSubmit}>Absenden</button>
            </form>

        </>

    )

}