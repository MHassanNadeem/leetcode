package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #38. Count and Say
 * href: https://leetcode.com/problems/count-and-say/ */
public class CountAndSay {
    
    public static String solve(int n){
        if(n == 0) return "";
        
        StringBuffer sbOld = new StringBuffer("1");
        StringBuffer sb = sbOld;
        
        for(int i=1; i<n; i++){
            sb = new StringBuffer("");
            for(int j=0; j<sbOld.length(); j++){
                int digit = Character.getNumericValue( sbOld.charAt(j) );
                int count = 1;
                
                while((j+1)<sbOld.length() && sbOld.charAt(j) == sbOld.charAt(j+1)){
                    count++;j++;
                }
                
                sb.append( count );
                sb.append( digit );
            }
            
            sbOld = sb;
        }
        
        return sbOld.toString();
    }

    
    @Test
    public void test(){
        assertEquals("", solve(0));
        assertEquals("1", solve(1));
        assertEquals("11", solve(2));
        assertEquals("21", solve(3));
        assertEquals("1113213211", solve(8));
    }
}
