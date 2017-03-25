package leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/* #13. Roman to Integer
 * href: https://leetcode.com/problems/roman-to-integer/ */
public class RomanToInteger {
    
    private static final HashMap<Character, Integer> map = new HashMap<>();
    static{
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    
    public static int solve(String s){
        if(s.length() == 0) return 0;
        
        int sum = 0;
        
        for(int i=0; i<s.length()-1; i++){
            int v1 = map.get(s.charAt(i));
            int v2 = map.get(s.charAt(i+1));
            if(v1 >= v2){
                sum += v1;
            }else{
                sum -= v1;
            }
        }
        
        return sum + map.get(s.charAt(s.length()-1));
    }

    
    @Test
    public void test(){
        assertEquals(10, solve("X"));
        assertEquals(4, solve("IV"));
        assertEquals(6, solve("VI"));
        assertEquals(7, solve("VII"));
        assertEquals(99, solve("XCIX"));
        assertEquals(91, solve("XCI"));
        assertEquals(1918, solve("MCMXVIII"));
    }
}
