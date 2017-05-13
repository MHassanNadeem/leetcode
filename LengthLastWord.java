package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #58. Length of Last Word
 * href: https://leetcode.com/problems/length-of-last-word */
public class LengthLastWord {
    
    public static boolean isSpace(char c){
        return c == ' ';
    }
    
    public static int solve(String s){
        int wordEnd = s.length()-1;
        int wordStart;
        
        while( wordEnd>=0 && isSpace(s.charAt(wordEnd)) ){
            wordEnd--;
        }
        
        wordStart = wordEnd;
        
        while( wordStart>=0 && !isSpace(s.charAt(wordStart)) ){
            wordStart--;
        }
        
        return wordEnd-wordStart;
    }

    
    @Test
    public void test(){
        assertEquals(5, solve("Hello World"));
        assertEquals(5, solve("World"));
        assertEquals(5, solve("  World"));
        assertEquals(5, solve("World  "));
        assertEquals(5, solve("  World  "));
        assertEquals(0, solve(""));
        assertEquals(0, solve("   "));
    }
}
