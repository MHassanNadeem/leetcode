package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #461. Hamming Distance
 * href: https://leetcode.com/problems/hamming-distance/description/ */
public class HammingDistance {
    
    public static int solve(int x, int y){
        int xor = x^y;
        int dist = 0;
        
        while(xor != 0){
            if(0x01 == (xor & 0x01)){
                dist++;
            }
            xor >>>= 1;
        }
        
        return dist;
    }

    
    @Test
    public void test(){
        assertEquals(0, solve(0,0));
        assertEquals(2, solve(1,4));
        assertEquals(8, solve(255,0));
    }
}
