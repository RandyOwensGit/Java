import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Person johnny = new Person("Johnny");
        johnny.setAge(50);

        System.out.println(johnny);
        System.out.println("Increase Johnny by 1 year.....");
        johnny.setAge(1);

        System.out.println(johnny);

        Person timmy = new Person("Timmy");
        System.out.println(timmy);

        timmy = johnny;
        System.out.println(timmy);

        System.out.println("Increasing Timmy 100 years.....");
        timmy.setAge(100);

        System.out.println(johnny);
        System.out.println(timmy);


    }


}