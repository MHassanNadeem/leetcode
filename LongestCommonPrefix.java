package leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Arrays;

/* #14. Longest Common Prefix
 * href: https://leetcode.com/problems/longest-common-prefix/ */
public class LongestCommonPrefix {
    
    public static String solve(String[] strs){
        if(strs.length == 0) return "";
        
        int prefixLen;
        
        for(prefixLen = 0; prefixLen < strs[0].length(); prefixLen++){
            for(int i = 1; i<strs.length; i++){
                if( !(prefixLen < strs[i-1].length() &&
                        prefixLen < strs[i].length() &&
                        strs[i-1].charAt(prefixLen) == strs[i].charAt(prefixLen)) ){
                    return strs[0].substring(0, prefixLen);
                }
            }
        }

        return strs[0].substring(0, prefixLen);
    }

    
    @Test
    public void test(){
        assertEquals("pre", solve(new String[]{"preclude", "prescience", "prevent"}));
        assertEquals("a", solve(new String[]{"a"}));
        assertEquals("a", solve(new String[]{"a", "a"}));
        assertEquals("", solve(new String[]{""}));
        assertEquals("", solve(new String[]{"abc",""}));
    }
}
