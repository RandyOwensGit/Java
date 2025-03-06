
import java.util.Scanner;

public class SumOfASequenceTheSequel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("First number?");
        int lowerBound = Integer.valueOf(scanner.nextLine());
        
        System.out.println("Second number?");
        int upperBound = Integer.valueOf(scanner.nextLine());
        
        // While Loop Solution
//        int i = lowerBound;
//        int sum = 0;
//        while (i <= upperBound) {
//            sum += i;
//            i++;
//        }
//   


        // For Loop Solution
        int sum = 0;
        for (int i = lowerBound; i <= upperBound; i++) {
            sum += i;
        }
        
        System.out.println("The sum is: " + sum);
        
    }
}
