package com.asb.example.jsonoperation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonToJavaToJsonMain {

    public static void main(String[] args){
        ObjectMapper mapper = new ObjectMapper();
        try{
            EmployeeModel employeeModel = new EmployeeModel();
            employeeModel.setEmpId1(1111);
            employeeModel.setName("John Doe");
            employeeModel.setPassword("mysecret");
            employeeModel.setPhone(9876543210L);

            //convert java object to json // deserialization
            //String jsonString = mapper.writeValueAsString(employeeModel);

            String jsonString = "{\"deptId\":4445,\"empId\":1111,\"name\":\"John Doe\",\"password\":\"mysecret\"}";
            System.out.println("JSON version of employee object");
            System.out.println(jsonString);

            //convert json string to java object
            EmployeeModel emp = mapper.readValue(jsonString, EmployeeModel.class);
            System.out.println("Object version of employee json: "+ emp.getName());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
