/*
 *UC3
 *@author Apoorv
 * Date:26/02/26
 *REG:RA2411026010268
 */
import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String[] args){
        String word="madam";
        boolean isPalindrome=true;

        int n=word.length()-1;
        int start=0;
        for(int i=n;i>0;i--)
        {
            if(word.charAt(i)!=word.charAt(start))
            {
                isPalindrome=false;
                break;
            }
            start++;
        }
        if(isPalindrome)
        {
            System.out.println(word+" is a Palindrome");
        }
        else
        {
            System.out.println(word+"is not a Palindrome");
        }
    }
}