

import './App.css'
import EmployeeOverview from "./EmployeeOverview.tsx";
import {Route, Router, Routes} from "react-router-dom";
import EmployeeModifiyCard from "./EmployeeModifiyCard.tsx";
import EmployeeAddCard from "./EmployeeAddCard.tsx";
import {useEffect, useState} from "react";
import axios from "axios";
import type {TypeEmployee} from "./types/TypeEmployee.ts";

function App() {
    const [employees, setEmployees] = useState<TypeEmployee[]>([])




    function getAllEmployees(){
        axios.get("/api/all")
            .then(response => {setEmployees(response.data)
                console.log("Anfrage ist raus ")})
    }



    useEffect(()=>{
        getAllEmployees()

    },[])


  return (

    <>
        <Routes>
            <Route path={"/"} element={<EmployeeOverview employees={employees} getAllEmployees={getAllEmployees}  />}  />
            <Route path={"/detail/:id"} element={<EmployeeModifiyCard getAllEmployees={getAllEmployees}/>} />
            <Route path={"/employeeadd"} element={<EmployeeAddCard reload={getAllEmployees}/>}/>

        </Routes>

    </>
  )

}

export default App
