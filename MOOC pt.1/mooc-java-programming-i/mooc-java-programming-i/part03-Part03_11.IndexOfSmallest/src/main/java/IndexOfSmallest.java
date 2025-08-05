
import java.util.ArrayList;
import java.util.Scanner;

public class IndexOfSmallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // implement here a program that reads user input
        // until the user enters 9999
        
        ArrayList<Integer> numbers = new ArrayList<>();
        
        int smallestValue = Integer.valueOf(scanner.nextLine());
        numbers.add(smallestValue);
        
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            
            if (input == 9999) {
                break;
            }

            if (smallestValue > input) {
                smallestValue = input;
            }
            
            numbers.add(input);
        }
        
        // after that, the program prints the smallest number
        // and its index -- the smallest number
        // might appear multiple times
        System.out.println("Smallest number: " + smallestValue);
        
        int index = 0;
        while (index < numbers.size()) {
            if (numbers.get(index) == smallestValue) {
                System.out.println("Found at index: " + index);
            }
            index++;
        }
        
    }
}
