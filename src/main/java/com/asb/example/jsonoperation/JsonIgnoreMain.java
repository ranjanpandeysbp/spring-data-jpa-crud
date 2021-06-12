package com.asb.example.jsonoperation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonIgnoreMain {

    public static void main(String[] args){
        ObjectMapper mapper = new ObjectMapper();
        try{
            EmployeeModel employeeModel = new EmployeeModel();
            employeeModel.setEmpId1(1111);
            employeeModel.setName("John Doe");
            //employeeModel.setPassword("mysecret");
            //employeeModel.setPhone(9876543210L);

            //convert java object to json // serialization
            String jsonString = mapper.
                    writerWithDefaultPrettyPrinter().
                    writeValueAsString(employeeModel);

            System.out.println("JSON version of employee object");
            System.out.println(jsonString);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
