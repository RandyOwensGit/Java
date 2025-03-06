
import java.util.Scanner;

public class AverageOfTwoNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.println("Give the first number:");
        int numOne = Integer.valueOf(scanner.nextLine());
        
        System.out.println("Give the second number:");
        int numTwo = Integer.valueOf(scanner.nextLine());
        
        System.out.println("The average is " + ((numOne + numTwo) / 2.0));
    }
}
