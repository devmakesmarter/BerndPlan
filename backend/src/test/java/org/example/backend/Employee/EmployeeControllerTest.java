package org.example.backend.Employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Test
    void getAll_shouldReturnEmptyList() throws Exception {

        //Given
        Employee testEmployee = new Employee("A","B",ExecutiveOrEmployee.EMPLOYEE,EmployeeProfession.APOTHEKER, LocalDate.of(1980,01,01),"45");
        employeeRepo.save(testEmployee);
        //When
        mockMvc.perform(MockMvcRequestBuilders.get("/api/all"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                              [
                                {
                                  "firstName": "A",
                                  "lastName": "B",
                                  "executiveOrEmployee": "EMPLOYEE",
                                  "employeeProfession": "APOTHEKER",
                                  "birthDate": "1980-01-01",
                                  "id": "45"
                                 }    
                              ]
                          """

                ));
        //Then



    }

    @Test
    void addEmployee_shouldReturnEmployee() throws Exception {
        //Given
        //When
        mockMvc.perform(MockMvcRequestBuilders.post("/api/add").contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                {
                                 "firstName" : "AddedForTest",
                                 "lastName": "LastAddedForTest",
                                 "executiveOrEmployee": "EMPLOYEE",
                                 "employeeProfession": "PTA",                                                                                                                               
                                 "birthDate": "1985-01-02"                                                               
                                }
                                """))
                //Then
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                    {
                                     "firstName" : "AddedForTest",
                                 "lastName": "LastAddedForTest",
                                 "executiveOrEmployee": "EMPLOYEE",
                                 "employeeProfession": "PTA",                                                                                                                               
                                 "birthDate": "1985-01-02" 
                                    }
                 
                                   """
                )
                )
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty())
        ;
    }





    @Test
    @DirtiesContext
    void getEmployeeById_shouldReturnEmployeeWhenCalledWithRightId() throws Exception{
            //Given
             Employee testEmployee = new Employee("A","B",ExecutiveOrEmployee.EMPLOYEE,EmployeeProfession.APOTHEKER, LocalDate.of(1980,01,01),"45");
             employeeRepo.save(testEmployee);

            //When
            mockMvc.perform(MockMvcRequestBuilders.get("/api/45"))
            //Then
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json(
                            """
                                {
                                    "firstName": "A",
                                    "lastName": "B",
                                    "executiveOrEmployee": "EMPLOYEE",
                                    "employeeProfession": "APOTHEKER",
                                    "birthDate": "1980-01-01",
                                    "id": "45"
                                 }
                                      """
                    ));

    }


    @Test
    @DirtiesContext
    void getEmployeeById_shouldReturn_Status404_WhenCalledWithWrongId() throws Exception{
        //Given

        //When
        mockMvc.perform(MockMvcRequestBuilders.get("/api/46"))
                //Then
                .andExpect(status().isNotFound());
    }



    @Test
    @DirtiesContext
    void deleteEmployeeById() throws Exception{
        //Given
        Employee testEmployee = new Employee("A","B",ExecutiveOrEmployee.EMPLOYEE,EmployeeProfession.APOTHEKER, LocalDate.of(1980,01,01),"45");
        employeeRepo.save(testEmployee);

        //When
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/46"))
                .andExpect(status().isOk());

        //Then


    }


}