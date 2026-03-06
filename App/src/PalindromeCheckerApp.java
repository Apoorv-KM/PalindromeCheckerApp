import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {
        LinkedList<Character> list = new LinkedList<>();

        // Insert characters into deque
        for (char c : input.toLowerCase().toCharArray()) {
            list.add(c);
        }

        int size = list.size();
        int mid = size / 2;

        LinkedList<Character> secondHalf = new LinkedList<>();
        for(int i = size - 1; i >= mid; i--){
            secondHalf.add(list.get(i));
        }

        for(int i = 0; i < mid; i++){
            if(list.get(i) != secondHalf.get(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}