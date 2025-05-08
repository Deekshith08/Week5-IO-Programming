import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
class Car{
    private String color;
    private String company;
    private int highSpeed;
    Car(String color, String company, int speed){
        this.color = color;
        this.company = company;
        this.highSpeed = speed;
    }
    public void start(){
        System.out.println("Engine started");
    }

    public int getHighSpeed() {
        return highSpeed;
    }

    public String getColor() {
        return color;
    }

    public String getCompany() {
        return company;
    }
}
public class ClassInfo {
    public static void main(String[] args) throws Exception{

        Scanner input = new Scanner(System.in);
        System.out.print("Enter class Name : ");
        String in = input.next();
        Class<?> cls = Class.forName(in);
        Field[] fields = cls.getDeclaredFields();
        System.out.println("Fields : ");
        for(Field field : fields){
            System.out.println(field.getName());
        }

        Method[] methods = cls.getDeclaredMethods();
        System.out.println("methods : ");
        for(Method method : methods){
            System.out.println(method.getName());
        }

        Constructor[] cons = cls.getDeclaredConstructors();
        System.out.println("Constructors : ");
        for(Constructor con:cons) {
            System.out.println(con.getName());
        }
    }
}
