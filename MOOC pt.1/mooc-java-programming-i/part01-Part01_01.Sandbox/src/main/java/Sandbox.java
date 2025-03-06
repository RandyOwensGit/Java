
public class Sandbox {

    public static void main(String[] args) {
        // Write your program here
        
        String string = "I am String. Wise and old.";
        System.out.println(string);
        System.out.println("------------------------");
        
        StringEdit(string);
        System.out.println("------------------------");
        
        System.out.println(string);
        
    }
    
    public static void StringEdit(String editString) {
        editString += "I am a new String now! Well not really but!";
        System.out.println(editString);
    }
}
