import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations{
    void add(int a, int b){
        System.out.println("Addition : " + (a+b));
    }
    void subtract(int a, int b){
        System.out.println("Subtraction : " + (a-b));
    }
    void multiply(int a, int b){
        System.out.println("Multiplication : " + (a*b));
    }
}
public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        MathOperations op = new MathOperations();
        Scanner input = new Scanner(System.in);
        String in = input.next();
        Method method = op.getClass().getDeclaredMethod(in,int.class,int.class);
        method.invoke(op,2,3);

    }
}
