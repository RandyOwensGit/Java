
import java.util.Scanner;

public class NameOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int highestAge = 0;
        String name = "";
        while (true) {
            String input = scanner.nextLine();
            
            if (input.isEmpty()) {
                break;
            }
            
            // split string
            String[] parts = input.split(",");
            
            int age = Integer.valueOf(parts[1]);
            
            if (age > highestAge) {
                highestAge = age;
                name = parts[0];
            }
            
        }
        
        System.out.println("Name of the oldest: " + name);
        
    }
}
