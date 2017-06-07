package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #75. Sort Colors
 * href: https://leetcode.com/problems/sort-colors/#/description */
public class SortColors {
    
    /* O(n) accepted solution. Slightly faster than solve2() */
    public static void solve(int[] nums){
        int index_0 = 0;
        int index_2 = nums.length - 1;
        
        for(int i=0; i<=index_2 && i>=index_0; ){
            if(nums[i] == 2){
                /* swap elements i and index_2 */
                nums[i] = nums[index_2];
                nums[index_2--] = 2;
            }else if(nums[i] == 0 && i>index_0){
                /* swap elements i and index_0 */
                nums[i] = nums[index_0];
                nums[index_0++] = 0;
            }else{
                i++;
            }
        }
    }
    
    /* O(n) accepted solution. */
    public static void solve2(int[] nums){
        int[] count = new int[3];
        
        for(int n:nums) count[n]++;
        
        Arrays.fill(nums, 0,                 count[0],          0);
        Arrays.fill(nums, count[0],          count[0]+count[1], 1);
        Arrays.fill(nums, count[0]+count[1], nums.length,       2);
    }

    
    @Test
    public void test(){
        test(new int[]{0});
        test(new int[]{1});
        test(new int[]{2});
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
