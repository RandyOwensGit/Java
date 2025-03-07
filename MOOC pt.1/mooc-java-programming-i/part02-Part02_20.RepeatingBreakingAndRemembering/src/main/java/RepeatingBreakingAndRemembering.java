
import java.util.Scanner;

public class RepeatingBreakingAndRemembering {

    public static void main(String[] args) {
        
        // This exercise is worth five exercise points, and it is 
        // gradually extended part by part.
        
        // If you want, you can send this exercise to the server
        // when it's just partially done. In that case the server will complain about 
        // the parts you haven't done, but you'll get points for the finished parts.
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Give numbers:");
        
        int sum = 0;
        int numOfNumbers = 0;
        int numOfEven = 0;
        while (true) {
            
            int number = Integer.valueOf(scanner.nextLine());
            
            if (number == -1) {
                break;
            }
            
            sum += number;
            numOfNumbers++;
            
            if (number % 2 == 0) {
                numOfEven++;
            }
            
        }
        
        System.out.println("Thx! Bye!");
        System.out.println("Sum: " + sum);
        System.out.println("Numbers: " + numOfNumbers);
        System.out.println("Average: " + (1.0 * sum / numOfNumbers));
        System.out.println("Even: " + numOfEven);
        System.out.println("Odd: " + (numOfNumbers - numOfEven));

    }
}
