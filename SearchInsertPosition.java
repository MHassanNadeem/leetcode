package leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Arrays;

/* #35. Search Insert Position
 * href: https://leetcode.com/problems/search-insert-position/ */
public class SearchInsertPosition {
    
    public static int solve(int[] nums, int target){
        int lo = 0;
        int hi = nums.length-1;
        int mid;
        
        while(lo <= hi){
            mid = (hi+lo)/2;
            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        
        return lo;
    }
    
    public static int solveLinear(int[] nums, int target){
        int i;
        for(i=0; i<nums.length && nums[i]<target; i++);
        return i;
    }

    
    @Test
    public void test(){
        assertEquals(2, solve(new int[]{1,3,5,6}, 5));
        assertEquals(1, solve(new int[]{1,3,5,6}, 2));
        assertEquals(4, solve(new int[]{1,3,5,6}, 7));
        assertEquals(0, solve(new int[]{1,3,5,6}, 0));
        assertEquals(0, solve(new int[]{1,3,5}, 0));
        assertEquals(1, solve(new int[]{1,3,5}, 3));
        assertEquals(3, solve(new int[]{1,3,5}, 7));
    }
}
