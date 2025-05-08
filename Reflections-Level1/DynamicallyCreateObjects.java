class Student{
    String name;
    int id;
    Student(String name, int id){
        this.name = name;
        this.id = id;
    }
    void display(){
        System.out.println("Name : " + name);
        System.out.println("ID : " + id);
    }
}
public class DynamicallyCreateObjects {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Student");
        Object obj = cls.getDeclaredConstructor(String.class, int.class).newInstance("Raj",9);
        Student st = (Student) obj;
        st.display();

    }
}
