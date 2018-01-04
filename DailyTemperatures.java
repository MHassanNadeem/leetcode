package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #739. Daily Temperatures
 * href: https://leetcode.com/problems/daily-temperatures/description/ */
public class DailyTemperatures {
    
    public static int[] solve(int[] nums){
        int[] ret = new int[nums.length];
        int j;
        
        for(int i=0; i<nums.length; i++){
            for(j=i+1; j<nums.length && nums[i]>=nums[j]; j++);
            ret[i] = j==nums.length?0:(j-i);
        }
        
        return ret;
    }

    
    @Test
    public void test(){
        assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, solve(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        assertArrayEquals(new int[]{8,1,5,4,3,2,1,1,0,0}, solve(new int[]{89,62,70,58,47,47,46,76,100,70}));
    }
}
