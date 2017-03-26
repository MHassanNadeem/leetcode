package leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* #15. 3Sum
 * href: https://leetcode.com/problems/3sum/ */
public class ThreeSum {
    
    public List<int[]> twoSum(int[] nums, int lo, int hi, int target){
        List<int[]> list = new ArrayList<>();
        int dual;
        /* Key = a number from the list, Value = Index of that number */
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=lo; i<=hi; i++){
            dual = target - nums[i];
            if(map.containsKey(dual)){
                /* Zap over duplicates */
                while(i < hi && nums[i] == nums[i+1]) i++;
                list.add( new int[]{map.get(dual), i} );
            }
            
            map.put(nums[i], i);
        }
        
        return list;
    }
    
    public List<List<Integer>> solve(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>(); 
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
                for(int[] ts:twoSum(nums, lo, hi, -nums[i])){
                    res.add(Arrays.asList(nums[i], nums[ts[0]], nums[ts[1]]));
                }
            }
        }
        return res;
    }

    
    @Test
    public void test(){
        System.out.println(solve(new int[]{0, 0, 0, 0}));
        System.out.println(solve(new int[]{4, 4, -8}));
        System.out.println(solve(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solve(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
        assertEquals(true, true);
    }
}
