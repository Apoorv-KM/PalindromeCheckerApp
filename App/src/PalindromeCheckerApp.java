import java.util.*;

interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }
        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : normalized.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

class RecursiveStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        return isPalindrome(normalized, 0, normalized.length() - 1);
    }
    private boolean isPalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome(str, start + 1, end - 1);
    }
}

class PalindromeService {
    private PalindromeStrategy strategy;
    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
    public boolean check(String input) {
        return strategy.checkPalindrome(input);
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to test performance: ");
        String input = scanner.nextLine();

        // List of strategies
        PalindromeStrategy[] strategies = {
                new StackStrategy(),
                new DequeStrategy(),
                new RecursiveStrategy()
        };

        String[] names = {"Stack Strategy", "Deque Strategy", "Recursive Strategy"};

        System.out.println("\nPerformance Comparison:");

        for (int i = 0; i < strategies.length; i++) {
            PalindromeService service = new PalindromeService(strategies[i]);

            long startTime = System.nanoTime();
            boolean result = service.check(input);
            long endTime = System.nanoTime();

            long duration = endTime - startTime; // nanoseconds

            System.out.printf("%-20s : %s, Time: %d ns%n", names[i],
                    result ? "Palindrome" : "Not Palindrome", duration);
        }

        scanner.close();
    }
}