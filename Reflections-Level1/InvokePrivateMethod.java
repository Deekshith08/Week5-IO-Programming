import java.lang.reflect.Method;

class Calculator{
    private void multiply(int a, int b){
        System.out.println("Result : " + (a*b));
    }
}
public class InvokePrivateMethod {
    public static void main(String[] args) throws Exception{
        Calculator calci = new Calculator();
        Method method = calci.getClass().getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true);
        method.invoke(calci,2,3);
    }


}
