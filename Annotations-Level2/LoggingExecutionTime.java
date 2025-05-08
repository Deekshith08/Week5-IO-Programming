import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime{

}
public class LoggingExecutionTime {
    @LogExecutionTime
    public void fastMethod() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        System.out.println("Fast method completed.");
    }
    @LogExecutionTime
    public void slowMethod() {
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }
        System.out.println("Slow method completed.");
    }
    public static void main(String[] args) {
        LoggingExecutionTime logger = new LoggingExecutionTime();
        for (Method method : LoggingExecutionTime.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                try {
                    long startTime = System.nanoTime();
                    method.invoke(logger);
                    long endTime = System.nanoTime();
                    System.out.println("Execution Time of " + method.getName() + ": " + (endTime - startTime) + " ns");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
