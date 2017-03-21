package leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Random;

/* #9 Palindrome Number
 * href: https://leetcode.com/problems/palindrome-number/ */
public class PalindromeNumber {
    
    public static boolean solve(int x){
        if(x == 0) return true;
        if(x < 0 || x%10 == 0) return false;
        
        int rev = 0;
        
        while(x != 0){
            int tail = x%10;
            x /= 10;
            if(x == rev) return true;
            rev = rev*10 + tail;
            if(x == rev) return true;
        }
        
        return false;
    }

    public static void main(String[] args) {

    }
    
    @Test
    public void test(){
        final Random rand = new Random();
        final int COUNT = 100000;
        
        for(int i=0; i<COUNT; i++){
            int randomNum = rand.nextInt( Integer.MAX_VALUE ) + Integer.MIN_VALUE/2;
            String numStr = Integer.toString(randomNum);
            
            System.out.println(randomNum);
            
            if(randomNum < 0){
                assertEquals(false, solve(randomNum));
            }else{
                String revStr = new StringBuffer( numStr ).reverse().toString();
                assertEquals(numStr.equals(revStr), solve(randomNum));
            }
        }
    }

}
