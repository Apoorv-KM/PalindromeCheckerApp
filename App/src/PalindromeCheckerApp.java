import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[]args){
        System.out.println("Welcome to Palindrome Checker App");
        System.out.println("Version: 1.0");
        System.out.println("System initialized sucessfully");

        Scanner sc = new Scanner(System.in);

        System.out.print("Input text: ");
        String input = sc.nextLine();

        boolean isPalindrome = true;

        for (int i = 0; i < input.length() / 2; i++) {

            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Is it a Palindrome? : " + isPalindrome);

        sc.close();
    }
}

