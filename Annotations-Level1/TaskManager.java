import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface TaskInfo{
    String priority();
    String assignedTo();
}

public class TaskManager {
    @TaskInfo(priority = "1", assignedTo = "Manas")
    public void manage(){

    }
    public static void main(String[] args) {
        try {
            Method method = TaskManager.class.getMethod("manage");
            if(method.isAnnotationPresent(TaskInfo.class)){
                TaskInfo info = method.getAnnotation(TaskInfo.class);
                System.out.println("Priority : " + info.priority());
                System.out.println("assignedTo : " + info.assignedTo());
            }
        }
        catch(NoSuchMethodException e){
            e.printStackTrace();
        }

    }
}
