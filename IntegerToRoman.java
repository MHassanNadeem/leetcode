package leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/* #12. Integer to Roman
 * href: https://leetcode.com/problems/integer-to-roman/ */
public class IntegerToRoman {
    
    private static final int[] list;
    private static final HashMap<Integer, String> map = new HashMap<>();
    static{
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        
        list = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    }
    
    public static String solve(int num){
        StringBuffer s = new StringBuffer();
        
        while(num > 0){
            for(int i=list.length - 1; i>=0; i--){
                if(num >= list[i]){
                    s.append( map.get(list[i]) );
                    num -= list[i];
                    break;
                }
            }
        }
        
        return s.toString();
    }

    
    @Test
    public void test(){
        assertEquals("X", solve(10));
        assertEquals("III", solve(3));
        assertEquals("IV", solve(4));
        assertEquals("IX", solve(9));
        assertEquals("XIV", solve(14));
        assertEquals("XLIV", solve(44));
        assertEquals("XL", solve(40));
        
        for(int i=0; i<4000; i++){
            assertEquals(i, RomanToInteger.solve( solve(i) ));
        }
    }
}
