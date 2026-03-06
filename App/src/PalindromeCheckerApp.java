import java.util.Scanner;

class PalindromeChecker {

    // Public method exposed to users
    public boolean checkPalindrome(String input) {

        // Normalize string
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        return isPalindrome(normalized, 0, normalized.length() - 1);
    }

    // Recursive helper method
    private boolean isPalindrome(String str, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindrome(str, start + 1, end - 1);
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (checker.checkPalindrome(input)) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}