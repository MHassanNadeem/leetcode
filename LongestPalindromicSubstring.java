package leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Arrays;

/* #5. Longest Palindromic Substring
 * href: https://leetcode.com/problems/longest-palindromic-substring/ */
public class LongestPalindromicSubstring {
    private static int maxLen = 0;
    private static int index = 0;
    
    private static void expand(String s, int i, int j){
        while(i >= 0 && j < s.length() &&  s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        
        int palanLen = j-i-1;
        
        if(palanLen > maxLen){
            index = i+1;
            maxLen = palanLen;
        }
    }
    
    public static String solve(String s){
        maxLen = index = 0;
        
        if(s.length() < 2) return s;
        
        for(int i=0; i<s.length()-1; i++){
            expand(s, i, i);
            expand(s, i, i+1);
        }
        
        return s.substring(index, index + maxLen);
    }

    
    @Test
    public void test(){
        assertEquals("bab", solve("babad"));
        assertEquals("saas", solve("saas"));
        assertEquals("saas", solve("Xsaas"));
        assertEquals("saas", solve("saasX"));
        assertEquals("bb", solve("cbbd"));
        assertEquals("ddtattarrattatdd", solve("babaddtattarrattatddetartrateedredividerb"));
    }
}
