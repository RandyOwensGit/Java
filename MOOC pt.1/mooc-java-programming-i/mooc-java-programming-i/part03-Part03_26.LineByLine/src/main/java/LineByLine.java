
import java.util.Scanner;

public class LineByLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String text = "";
        
        while (true) {
            
            String input = scanner.nextLine();
            
            if (input.isEmpty()) {
                break;
            }
            
            String[] parts = input.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
            
        }

    }
}
