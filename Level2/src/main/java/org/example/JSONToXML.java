package org.example;

import org.json.JSONObject;
import org.json.XML;

public class JSONToXML {
    public static void main(String[] args) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "riya");
        jsonObj.put("age", 21);
        jsonObj.put("email", "riya@gmail.com");

        String xml = XML.toString(jsonObj);
        System.out.println(xml);
    }
}
