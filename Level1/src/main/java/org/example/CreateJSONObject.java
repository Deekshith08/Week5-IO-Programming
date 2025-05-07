package org.example;
import org.json.JSONObject;
import org.json.JSONArray;
public class CreateJSONObject {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("Name","Raj");
        obj.put("Age",22);

        JSONArray subjects = new JSONArray();
        subjects.put("Maths");
        subjects.put("Physics");
        subjects.put("Chemistry");

        obj.put("Subjects",subjects);
        System.out.println(obj.toString());


    }
}
