package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #53. Maximum Subarray
 * href: https://leetcode.com/problems/maximum-subarray/ */
public class MaximumSubarray {
    
    public static int solve(int[] nums){
        int maxEndingHere = nums[0];
        int max = maxEndingHere;
        
        for(int i = 1; i<nums.length; i++){
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            max = Math.max(max, maxEndingHere);
        }
        
        return max;
    }

    
    @Test
    public void test(){
        assertEquals(-1, solve( new int[]{-2, -1, -2} ));
        assertEquals(6, solve( new int[]{-2,1,-3,4,-1,2,1,-5,4} ));
        assertEquals(10, solve( new int[]{10, -1, -2, -3, -4} ));
        assertEquals(10, solve( new int[]{-1, -2, -3, -4, 10} ));
        assertEquals(10, solve( new int[]{-1, -2, 10, -3, -4} ));
        assertEquals(19, solve( new int[]{10, -1, 10} ));
        assertEquals(19, solve( new int[]{10, -50, 10, -1, 10} ));
    }
}
