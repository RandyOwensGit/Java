
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Give a number: ");
        int factorialNum = Integer.valueOf(scanner.nextLine());
        
        int factorialSum = 1;
        if (factorialNum != 0) {
            
            for (int i = 1; i <= factorialNum; i++) {
                factorialSum *= i;
            }
            
        }
        
        System.out.println("Factorial: " + factorialSum);
        
    }
}
