package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #383. Ransom Note
 * href: https://leetcode.com/problems/ransom-note/#/description */
public class RansomNote {
    
    public static boolean solve(String ransomNote, String magazine){
        int[] freq = new int[26]; /* Initialized to zero as per java specs */
        
        for(char c:ransomNote.toCharArray()){
            freq[c-'a']++;
        }
        
        for(char c:magazine.toCharArray()){
            freq[c-'a']--;
        }
        
        for(int i:freq){
            if(i>0) return false;
        }
        
        return true;
    }

    
    @Test
    public void test(){
        assertEquals(false, solve("a", "b"));
        assertEquals(false, solve("aa", "ab"));
        assertEquals(true, solve("ab", "ab"));
        assertEquals(true, solve("aa", "aab"));
    }
}
