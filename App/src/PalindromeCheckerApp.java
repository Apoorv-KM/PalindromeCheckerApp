import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input text: ");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input);

        System.out.println("Is it a Palindrome? : " + result);

        scanner.close();
    }

    public static boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) return false;

        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char c : clean.toCharArray()) {
            stack.push(c);
        }

        for (char c : clean.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}
