package leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Arrays;

/* #8. String to Integer
 * href: https://leetcode.com/problems/string-to-integer-atoi/ */
public class StringToInteger {
    
    private static boolean isDigit(char c){
        return (c>='0' && c<='9');
    }
    
    private static boolean isSpace(char c){
        return (c==' ' || c=='\t' || c=='\n' || c=='\r');
    }
    
    private static boolean isSign(char c){
        return (c == '+' || c == '-');
    }
    
    private static boolean isInvalidChar(char c){
        return !(isDigit(c) || isSpace(c) || isSign(c));
    }
    
    private static int char2int(char c){
        return c-'0';
    }
    
    
    public static int solve(String str){
        int val = 0;
        int i = 0;
        int sign = 1;
        int len = str.length();
        
        /* Eat whitespaces */
        while( i<len && isSpace(str.charAt(i)) ) i++;
        if(i == len || isInvalidChar( str.charAt(i) ) ) return 0;
        
        /* Parse sign */
        if( str.charAt(i) == '-' ){
            sign = -1;
            i++;
        }else if( str.charAt(i) == '+' ){
            i++;
        }
        
//        /* Eat whitespaces */
//        while( i<len && isSpace(str.charAt(i))) i++;
        /* Eat leading zeros */
        while( i<len && str.charAt(i) == '0') i++;
        if(i == len || isInvalidChar( str.charAt(i) )) return 0;
        
        /* Parse integer value */
        for(; i<len; i++){
            char c = str.charAt(i);
            if( !isDigit(c) ) break;

            int temp = val*10 + char2int(c);
            if(temp > val && ((temp - char2int(c))/10 == val)){
                val = temp;
            }else{
                /* Overflow */
                if(sign == 1){
                    return Integer.MAX_VALUE;
                }else{
                    return Integer.MIN_VALUE;
                }
            }
        }
        
        return sign*val;
    }

    
    @Test
    public void test(){
        assertEquals(0, solve(""));
        assertEquals(0, solve(" "));
        assertEquals(0, solve("abc"));
        assertEquals(0, solve(" abc"));
        assertEquals(123, solve("   123   "));
        assertEquals(123, solve("   123abc"));
        assertEquals(123, solve("   123 abc"));
        assertEquals(12300, solve("   0012300   "));
        assertEquals(0, solve("   +0 123   "));
        assertEquals(1, solve("   +01 123   "));
        
        /* Edge Cases */
        assertEquals(Integer.MAX_VALUE-1, solve( "2147483646" )); /* Less than max value */
        assertEquals(Integer.MAX_VALUE, solve( "2147483647" )); /* Max value */
        assertEquals(Integer.MAX_VALUE, solve( "2147483648" )); /* Greater than max value */
        
        assertEquals(Integer.MIN_VALUE, solve( "-2147483649" )); /* Less than min value */
        assertEquals(Integer.MIN_VALUE, solve( "-2147483648" )); /* Min value */
        assertEquals(Integer.MIN_VALUE+1, solve( "-2147483647" )); /* Greater than min value */
    }
}
