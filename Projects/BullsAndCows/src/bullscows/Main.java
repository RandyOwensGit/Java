package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Handles Game Logic
        startGame(scanner);

        scanner.close();

    }

    // Game Logic Handler
    static public void startGame(Scanner scanner) {

        // Ask user for code length (Game Difficulty) (Max 36)
        int codeLength = 0;
        try {
            System.out.println("Input the length of the secret code:");
            codeLength = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Error: Invalid Input");
            return;
        }

        if (codeLength < 1) {
            System.out.println("Error: Secret code must be at least 1 character long.");
            return;
        }

        // Symbols entered is unique digits (10) + range from letters [a, remainder]
        int symbolCount = 0;
        try {
            System.out.println("Input the number of possible symbols in the code:");
            symbolCount = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Error: Invalid Input");
            return;
        }

        // Generate secret code with length from user
        String secretCode = "";
        try {
            secretCode = generateSecretCode(codeLength, symbolCount);
        } catch (Exception e) {
            System.out.println("Error: It's not possible to generate a code with length longer then possible symbols.");
            return;
        }

        // validate code length is not greater then symbolCount
        if (codeLength > symbolCount) {
            System.out.println("Error - Code length not valid. Needs to be less then possible symbols value.");
            return;
        }

        // Validate code
        if (secretCode == null || codeLength > symbolCount) {
            System.out.println("Error - Code length not valid. Please restart.");
            return;
        }

        // Game Start
        System.out.println(codePreparedMessage(codeLength, symbolCount));
        System.out.println("Okay, let's start a game!");

        // Game Loop
        boolean gameWon = gameLoop(scanner, secretCode);

        // Game Finished - Winning Message
        System.out.println("Congratulations! You guessed the secret code.");
    }

    // Game Loop
    static public boolean gameLoop(Scanner scanner, String secretCode) {
        // return true when they win
        int turn = 1;
        while (true) {
            System.out.println("Turn " + turn + ":");

            // get user guess
            String guess = scanner.nextLine();

            // validate user input
            if (guess.length() != secretCode.length()) {
                System.out.println("Invalid Input. Try Again.");
                continue;
            }

            // Get Grade
            int[] grade = gradeGuess(secretCode, guess);

            // Grade Result
            String gradeResult = gradeStatement(grade[0], grade[1]);
            System.out.println(gradeResult);

            // check if they won - Compare correct Bulls to Length
            if (grade[0] == secretCode.length()) {
                return true;
            }

            turn++;

        }

    }

    // Grade Guess
    // return [bulls guessed right, cows guessed right]
    static public int[] gradeGuess(String secretCode, String userGuess) {
        char[] code = secretCode.toCharArray();
        char[] guess = userGuess.toCharArray();

        // iterate over Strings comparing char values
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < code.length; i++) {
            // direct match is a bull - indirect match is a cow
            if (code[i] == guess[i]) {
                bulls++;
            } else if (containsValue(code, guess[i])) {
                cows++;
            }
        }

        return new int[]{bulls, cows};
    }

    // returns true if the parameter array contains the parameter letter
    // Determines if the letter is a cow value
    static public boolean containsValue(char[] charArray, char letter) {
        // loop over charArray
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == letter) {
                return true;
            }
        }

        return false;
    }

    // generate a single random digit that isn't already in passed string
    static public String generateRandomDigit(String code, int length) {
        StringBuilder possibleChars = new StringBuilder("0123456789abcdefghijklmnopqrstuvwxyz");
        possibleChars.setLength(length);

        while (true) {
            // Generate random digit 0-length
            int index = new Random().nextInt(possibleChars.length());

            // get char at index of possibleChars and remove it
            String temp = "" + possibleChars.charAt(index);
            possibleChars.deleteCharAt(index);

            // check if digit already exists inside code string
            // return digit if it doesn't already exist
            if (code.contains(temp)) {
                continue;
            } else {
                return temp;
            }
        }
    }

    // generates secret code with length 1-10
    static public String generateSecretCode(int length, int symbolCount) throws Exception {
        // check if length is valid
        if (symbolCount < 1 || symbolCount > 36) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            return null;
        }

        StringBuilder code = new StringBuilder();

        // Generate unique values for code
        for (int i = 0; i < length; i++) {
            String digit = generateRandomDigit(code.toString(), symbolCount);

            code.append(digit);
        }

        return code.toString();

    }

    // Generate grade statement
    public static String gradeStatement(int bulls, int cows) {
        StringBuilder grade = new StringBuilder("Grade: ");

        // User didn't get a single digit right
        if (bulls == 0 && cows == 0) {
            grade.append("None");
        }

        // Fill out bulls right amount
        if (bulls == 1) {
            grade.append(bulls + " bull");
        } else if (bulls > 1) {
            grade.append(bulls + " bulls");
        }

        if (bulls > 0 && cows > 0) {
            grade.append(" and ");
        }

        // Fill out cows right amount
        if (cows == 1) {
            grade.append(cows + " cow");
        } else if (cows > 1) {
            grade.append(cows + " cows");
        }

        return grade.toString();

    }

    // Generate secret code prepared statement
    public static String codePreparedMessage(int length, int range) {
        StringBuilder message = new StringBuilder("The secret is prepared: ");

        // get star count from length
        for (int i = 0; i < length; i++) {
            message.append("*");
        }

        // append digit range, always 0-9
        message.append(" (0-9");

        // if symbol range is not greater then 10
        if (range < 11) {
            message.append(").");
            return message.toString();
        }
        message.append(", ");

        // append letter range - checking if its 11 then it is only a
        if (range == 11) {
            message.append("a).");
            return message.toString();
        } else {
            message.append("a-" + (char) (97 + (range - 11)) + ").");
        }

        return message.toString();

    }

}
