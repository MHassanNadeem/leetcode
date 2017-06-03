package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* #66. Plus One
 * href: https://leetcode.com/problems/plus-one/ */
public class PlusOne {
    
    public static int[] solve(int[] digits){
        int carry = 1;
        int sum = 0;
        
        for(int i=digits.length-1; i>=0; i--){
            sum = digits[i] + carry;
            carry = sum/10;
            digits[i] = sum%10;
        }
        
        
        int[] result = new int[digits.length + carry];
        result[0] = carry;
        
        for(int i=digits.length-1; i>=0; i--){
            result[i+carry] = digits[i];
        }
        
        return result;
    }
    
    public static int[] solve2(int[] digits){
        int carry = 1;
        int sum = 0;
        
        for(int i=digits.length-1; i>=0; i--){
            sum = digits[i] + carry;
            carry = sum/10;
            digits[i] = sum%10;
            
            if(carry == 0) return digits;
        }
        
        /* If input string is 9 or 99 or 999 etc */
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    
    @Test
    public void test(){
        assertArrayEquals(new int[]{1}, solve(new int[]{0}));
        assertArrayEquals(new int[]{1,0}, solve(new int[]{9}));
        assertArrayEquals(new int[]{1,0,0}, solve(new int[]{9,9}));
        
        assertArrayEquals(new int[]{1}, solve2(new int[]{0}));
        assertArrayEquals(new int[]{1,0}, solve2(new int[]{9}));
        assertArrayEquals(new int[]{1,0,0}, solve2(new int[]{9,9}));
    }
}
