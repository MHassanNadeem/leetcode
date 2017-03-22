package leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Arrays;

/* #26 Remove Duplicates from Sorted Array
 * href: https://leetcode.com/problems/remove-duplicates-from-sorted-array/ */
public class RemoveDuplicatesSortedArray {
    
    public static int solve(int[] nums){
        if(nums.length == 0) return 0;
        
        int len = 0;
        
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                len++;
                nums[len] = nums[i];
            }
        }
        
        return (len+1);
    }

    
    @Test
    public void test(){
        int[] input = new int[]{0,1,1,1,2,3,3,4,5,5,5,5,5,6};
        int[] expected = new int[]{0,1,2,3,4,5,6};
        assertEquals(true, Arrays.equals(Arrays.copyOfRange(input, 0, solve(input)), expected));
    }
}
