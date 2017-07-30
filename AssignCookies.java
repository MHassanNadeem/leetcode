package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #455. Assign Cookies
 * href: https://leetcode.com/problems/assign-cookies/description/ */
public class AssignCookies {
    
    public static int solve(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        
        int satisfied = 0;

        for(int gi = g.length -1, si = s.length -1; gi>=0 && si>=0; gi--){
            if(s[si] >= g[gi]){
                satisfied++;
                si--;
            }
        }
        
        return satisfied;
    }

    
    @Test
    public void test(){
        assertEquals(1, solve(new int[]{1,2,3}, new int[]{1,1}));
        assertEquals(2, solve(new int[]{1,2}, new int[]{1,2,3}));
        
        assertEquals(0, solve(new int[]{10}, new int[]{1,2,3,4,5,6}));
        assertEquals(1, solve(new int[]{1,2,3,4,5,6}, new int[]{10}));
    }
}
