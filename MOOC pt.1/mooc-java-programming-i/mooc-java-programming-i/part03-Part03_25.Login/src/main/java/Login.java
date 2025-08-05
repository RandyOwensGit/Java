
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] alex = {"alex", "sunshine"};
        String[] emma = {"emma", "haskell"};
        
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        
        boolean login = false;
        if (username.equals("alex")) {
            if (password.equals("sunshine")) {
                login = true;
            }
        } else if (username.equals("emma")) {
            if (password.equals("haskell")) {
                login = true;
            }
        }
        
        if (login) {
            System.out.println("You have successfully logged in!");
        } else {
            System.out.println("Incorrect username or password!");
        }

    }
}
