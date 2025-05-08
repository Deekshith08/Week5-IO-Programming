import java.lang.reflect.Field;

class Person{
    String name;
    private int age;
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}
public class AccessPrivateField {
    public static void main(String[] args) throws Exception{
        Person p1 = new Person("Senthil", 9);
        Field field = p1.getClass().getDeclaredField("age");
        field.setAccessible(true);
        System.out.println("Old age : " + field.get(p1));
        field.set(p1,10);
        System.out.println("New age : " + field.get(p1));
    }
}
