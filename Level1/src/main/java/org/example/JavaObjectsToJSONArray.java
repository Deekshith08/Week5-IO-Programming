package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class JavaObjectsToJSONArray {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Chetana", 21, "chetana@example.com"));
        list.add(new Student("Mani", 20, "money@example.com"));
        list.add(new Student("Raj", 29, "raj@example.com"));

        JSONArray arr = new JSONArray();
        for (Student s : list) {
            JSONObject obj = new JSONObject();
            obj.put("name", s.name);
            obj.put("age", s.age);
            obj.put("email", s.email);
            arr.put(obj);
        }

        System.out.println(arr.toString(2));
    }
}

class Student {
    String name;
    int age;
    String email;

    Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
