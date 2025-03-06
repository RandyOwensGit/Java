
import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.println("Give the first number:");
        int numOne = Integer.valueOf(scanner.nextLine());
        
        System.out.println("Give the second number:");
        int numTwo = Integer.valueOf(scanner.nextLine());
        
        // prints
        System.out.println(numOne + " + " + numTwo + " = " + (numOne + numTwo));
        System.out.println(numOne + " - " + numTwo + " = " + (numOne - numTwo));
        System.out.println(numOne + " * " + numTwo + " = " + (numOne * numTwo));
        System.out.println(numOne + " / " + numTwo + " = " + (1.0 * numOne / numTwo));
    }
}
