import java.lang.annotation.*;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Todo{
    String task();
    String assignedTo();
    String priority() default "Medium";
}
public class PendingTasks {
    @Todo(task = "Task 1", assignedTo = "Sam", priority = "High")
    public void task1(){
        System.out.println("This is task1");
    }
    public void task2(){
        System.out.println("This is task2");
    }
    @Todo(task = "Task 3", assignedTo = "Ram")
    public void task3(){
        System.out.println("This is task3");
    }

    public static void main(String[] args) {
        Method[] methods = PendingTasks.class.getDeclaredMethods();
        System.out.println("Pending Task");
        for(Method method: methods){
            if(method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task : " + todo.task());
                System.out.println("Assigned To : " + todo.assignedTo());
                System.out.println("priority : " + todo.priority());
            }
        }
    }
}
