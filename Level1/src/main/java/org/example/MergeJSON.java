package org.example;

import org.json.JSONObject;

import java.util.Map;

public class MergeJSON {
    public static void main(String[] args) {
        JSONObject obj1 = new JSONObject();
        obj1.put("Name","raj");
        obj1.put("id",1);
        JSONObject obj2 = new JSONObject();
        obj2.put("email","rajrajchora@gmail.com");
        JSONObject merged = new JSONObject(obj1.toMap());
        for(Map.Entry<String,Object> entry : obj2.toMap().entrySet()){
            merged.put(entry.getKey(),entry.getValue());
        }
        System.out.println(merged.toString());
    }
}
