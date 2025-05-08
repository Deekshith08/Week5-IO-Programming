import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod{
    String level() default "HIGH";
}
public class CustomImportanMethod {
    @ImportantMethod(level = "MEDIUM")
    public void method1(){
        System.out.println("Method 1 ....");
    }
    @ImportantMethod()
    public void method2(){
        System.out.println("Method 2 .....");
    }

    public static void main(String[] args) {
        Method[] methods = CustomImportanMethod.class.getMethods();
        System.out.println("Important methods : ");
        for(Method method : methods){
            if(method.isAnnotationPresent(ImportantMethod.class)){
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method : " + method.getName() + " | Level : " + annotation.level());
            }
        }
    }
}
