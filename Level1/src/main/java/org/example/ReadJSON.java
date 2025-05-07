package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

class User{
    public String name;
    public String email;
    public String gender;
    public User(){}
    public User(String name, String email, String gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

public class ReadJSON {
    public static void main(String[] args) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(new File("data.json"),User.class);
            System.out.println(user.toString());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
