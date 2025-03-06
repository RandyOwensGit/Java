
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfNumbers = 0;
        int sumOfNumbers = 0;
        
        while (true) {
            
            System.out.println("Give a number:");
            int number = Integer.valueOf(scanner.nextLine());
            
            if (number == 0) {
                break;
            }
            
            numOfNumbers += 1;
            sumOfNumbers += number;
            
        }
        
        System.out.println("Average of the numbers: " + (1.0 * sumOfNumbers / numOfNumbers));
        
    }
}
