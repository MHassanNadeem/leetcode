package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* #349. Intersection of Two Arrays
 * href: https://leetcode.com/problems/intersection-of-two-arrays/#/description */
public class IntersectionTwoArrays {
    
    public static int[] solve(int[] nums1, int[] nums2){
        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> s2 = new HashSet<Integer>();
        
        for(int n:nums1) s1.add(n);
        for(int n:nums2) s2.add(n);
        
        s1.retainAll(s2);
        
        return Arrays.stream(s1.toArray()).mapToInt(i->(Integer)i).toArray();
    }

    
    @Test
    public void test(){
        assertArrayEquals(new int[]{2}, solve(new int[]{1,2,2,1}, new int[]{2,2}));
        assertArrayEquals(new int[]{}, solve(new int[]{1,2,2,1}, new int[]{}));
        assertArrayEquals(new int[]{1,2}, solve(new int[]{1,2,2,1}, new int[]{1,2}));
    }
}
