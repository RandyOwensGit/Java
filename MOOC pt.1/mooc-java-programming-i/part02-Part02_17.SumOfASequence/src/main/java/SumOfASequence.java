
import java.util.Scanner;

public class SumOfASequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Last number?");
        int finalNumber = Integer.valueOf(scanner.nextLine());
        
        int i = 1;
        int sum = 0;
        while (i <= finalNumber) {
            sum += i;
            i++;
        }
        
        System.out.println("The sum is " + sum);
        
    }
}
