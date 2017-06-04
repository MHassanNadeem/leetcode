package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #69. Sqrt(x)
 * href: https://leetcode.com/problems/sqrtx/ */
public class Sqrt {
    
    /* O(log(x)) solution */
    public static int solve(int x){
        if(x == 0) return 0;
        
        int result = 0;
        int left = 1;
        int right = x;
        int mid;
        
        
        while(left <= right){
            mid = left + (right-left)/2; /* to prevent overflow */
            
            if(mid > x/mid){
                right = mid - 1;
            }else{
                left = mid + 1;
                result = mid;
            }
        }
        
        return result;
    }
    
    /* O(x) solution */
    public static int solve_linear(int x){
        int i;
        for(i=1; i*i<=x; i++){
            if(i*i == x) return i;
        }
        
        return i-1;
    }

    
    @Test
    public void test(){
        for(int i=0; i<10; i++){
            System.out.println(i);
            assertEquals(new Double(Math.sqrt(i)).intValue(), solve(i));
        }
        
        assertEquals(new Double(Math.sqrt(2147395599)).intValue(), solve(2147395599));
    }
}
