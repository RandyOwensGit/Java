
import java.util.ArrayList;
import java.util.Scanner;

public class ListSize {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();
        
        while (true) {
            String temp = scanner.nextLine();
            
            if(temp.isEmpty()) {
                break;
            }
            
            list.add(temp);
        }
        
        System.out.println("In total: " + list.size());

    }
}
