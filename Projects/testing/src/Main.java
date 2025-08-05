import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();

        strings.add("First");
        strings.add("Second");
        strings.add("Third");

        System.out.println(strings);

        removeLast(strings);
        removeLast(strings);

        System.out.println(strings);

    }

    private static void removeLast(ArrayList<String> strings) {

        strings.remove(strings.size() - 1);

    }

    private static int sum(ArrayList<Integer> numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;

    }

    private static void printNumbersInRange(ArrayList<Integer> numbers, int lowerLimit, int upperLimit) {

        for (int number : numbers) {

            if (number >= lowerLimit && number <= upperLimit) {
                System.out.println(number);
            }

        }

    }
}