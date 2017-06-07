package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #75. Sort Colors
 * href: https://leetcode.com/problems/sort-colors/#/description */
public class SortColors {
    
    /* O(n) accepted solution. */
    public static void solve(int[] nums){
        int[] count = new int[3];
        
        for(int n:nums) count[n]++;
        
        Arrays.fill(nums, 0,                 count[0],          0);
        Arrays.fill(nums, count[0],          count[0]+count[1], 1);
        Arrays.fill(nums, count[0]+count[1], nums.length,       2);
    }

    
    @Test
    public void test(){
        test(new int[]{0});
        test(new int[]{0, 1, 2});
        test(new int[]{2, 1, 0});
        test(new int[]{1, 2, 0});
        test(new int[]{2, 1, 1, 0, 2, 1, 0, 0, 2, 1, 0});
    }
    
    public void test(int[] nums){
        int[] sortedArray = nums.clone();
        Arrays.sort(sortedArray);
        
        solve(nums);
        assertArrayEquals(sortedArray, nums);
    }
}
