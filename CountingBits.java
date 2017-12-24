package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/* #338
 * href: https://leetcode.com/problems/counting-bits/description/ */
public class CountingBits {
    
    public static int[] solve(int num){
        int[] array = new int[num + 1];
        
        for(int i=1; i<=num; i++){
            array[i] = array[i>>1] + (i&1);
        }
        
        return array;
    }

    
    @Test
    public void test(){
        assertArrayEquals(new int[]{0,1,1,2,1,2}, solve(5));
    }
}
