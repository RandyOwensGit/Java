
import java.util.Scanner;

public class AgeOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int highestAge = 0;
        while (true) {
            String input = scanner.nextLine();
            
            if (input.isEmpty()) {
                break;
            }
            
            // split line
            String[] parts = input.split(",");
            int age = Integer.valueOf(parts[1]);
            
            if (age > highestAge) {
                highestAge = age;
            }
        }
        
        System.out.println("Age of the oldest: " + highestAge);
        
    }
}
