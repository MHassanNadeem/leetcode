package leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Arrays;

/* #28. Implement strStr()
 * href: https://leetcode.com/problems/implement-strstr/ */
public class StrStr {
    
    public static int solve(String haystack, String needle){
        if(needle.equals("")) return 0;
        
        int matchSize = 0;
        
        for(int i=0; i<haystack.length(); i++){
            if(needle.charAt(matchSize) == haystack.charAt(i)){
                matchSize++;
            }else{
                i = i - matchSize;
                matchSize = 0;
            }
            
            if(matchSize == needle.length()){
                return i - matchSize + 1;
            }
        }
        
        return -1;
    }

    
    @Test
    public void test(){
        test("mississippi", "issi");
        test("mississippi", "issip");
    }
    
    public void test(String haystack, String needle){
        assertEquals(haystack.indexOf(needle), solve(haystack, needle));
    }
}
