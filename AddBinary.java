package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #67. Add Binary
 * href: https://leetcode.com/problems/add-binary/#/description */
public class AddBinary {
    
    public static String solve(String a, String b){
        StringBuffer result = new StringBuffer( Math.max(a.length(), b.length()) + 1);
        
        int carry = 0;
        int sum;
        
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        
        while(indexA >= 0 || indexB >= 0 || carry > 0){
            sum = carry + 
                    (indexA<0?0:Character.getNumericValue(a.charAt(indexA))) + 
                    (indexB<0?0:Character.getNumericValue(b.charAt(indexB)));

            carry = sum/2;
            result.append( (char)('0' + sum%2) );
            indexA--; indexB--;
        }

        return result.reverse().toString();
    }

    
    @Test
    public void test(){
        assertEquals("0", solve("0", "0"));
        assertEquals("1", solve("0", "1"));
        assertEquals("1", solve("1", "0"));
        assertEquals("10", solve("1", "1"));

        assertEquals("100", solve("11", "1"));
        assertEquals("100", solve("1", "11"));
        
        assertEquals("11110", solve("1111", "1111"));
    }
}
