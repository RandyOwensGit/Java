
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNames = 0;
        int totalNumOfYears = 0;
        String longestName = "";

        while (true) {
            String input = scanner.nextLine();
            
            if (input.isEmpty()) {
                break;
            }
            
            numberOfNames++;
            
            // split string and get values
            String[] parts = input.split(",");
            
            int birthYear = Integer.valueOf(parts[1]);
            totalNumOfYears += birthYear;
            
            if (parts[0].length() > longestName.length()) {
                longestName = parts[0];
            }
            
        }
        
        // print out statistics answers
        System.out.println("Longest name: " + longestName);
        System.out.println("Average of the birth years: " + ((double) totalNumOfYears / numberOfNames));
        
    }
}
