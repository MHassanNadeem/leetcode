package leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Random;

/* #7 Reverse Integer
 * href: https://leetcode.com/problems/reverse-integer/ */
public class ReverseInteger {
    
    public static int solve(int x){
        int ret = 0;
        
        while(x != 0){
            int lastDigit = x%10;
            int newResult = ret*10 + lastDigit;
            x /= 10;
            
            /* Check for overflow */
            if( (newResult - lastDigit)/10 != ret) return 0;
            
            ret = newResult;
        }
        
        return (int)ret;
    }

    public static void main(String[] args) {
        
    }
    
    @Test
    public void test(){
        final Random rand = new Random();
        final int COUNT = 1000;
        
        for(int i=0; i<COUNT; i++){
            int randomNum = rand.nextInt( Integer.MAX_VALUE ) + Integer.MIN_VALUE/2;
            
            int revNum;

            String revNumStr;
            if(randomNum > 0){
                String numStr = Integer.toString(randomNum);
                revNumStr = new StringBuffer( numStr ).reverse().toString();
            }else{
                String numStr = Integer.toString( - randomNum);
                revNumStr = "-" + new StringBuffer( numStr ).reverse().toString();
            }
            
            try{
                revNum = Integer.parseInt( revNumStr );
            }catch(Exception e){
                revNum = 0;
            }
            
            assertEquals(revNum, solve(randomNum));
        }
        
        /* Extreme case */
        assertEquals(0, solve(Integer.MIN_VALUE));
    }

}
