
import java.util.Scanner;

public class IntegerInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // write your program here
        System.out.println("Give a number:");
        try { 
            int input = Integer.valueOf(scanner.nextLine());
            System.out.println("You gave the number " + input);
        } catch (Exception e) {
            System.out.println("OOps");
        }
    }
}
