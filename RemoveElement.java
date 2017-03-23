package leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Arrays;

/* #27. Remove Element
 * href: https://leetcode.com/problems/remove-element/ */
public class RemoveElement {
    
    public static int solve(int[] nums, int val){
        int len = 0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                nums[len++] = nums[i];
            }
        }
        
        return len;
    }

    
    @Test
    public void test(){
        int[] input_array = new int[]{3, 2, 2, 3};
        int input_val = 3;
        int[] expected = new int[]{2, 2};
        int[] actual = Arrays.copyOfRange(input_array, 0, solve(input_array, input_val));
        assertEquals(true, Arrays.equals( actual, expected));
    }
}
