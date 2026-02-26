/*
 *UC4
 *@author Apoorv
 * Date:26/02/26
 *REG:RA2411026010268
 */
import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = sc.nextLine();
        boolean isPalindrome=true;

        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        if(isPalindrome)
        {
            System.out.println(word+" is a Palindrome");
        }
        else
        {
            System.out.println(word+" is NOT a Palindrome");
        }
        sc.close();
    }
}