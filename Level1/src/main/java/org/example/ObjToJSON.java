package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

class Car{

    public String color;
    public String company;
    public Car(){}

    public Car(String color, String company){

        this.color = color;
        this.company = company;
    }
}
public class ObjToJSON {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Car car = new Car("Blue","XUV");
        String jsondata = mapper.writeValueAsString(car);
        System.out.println(jsondata);
    }
}
