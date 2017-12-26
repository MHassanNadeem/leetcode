package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* #537. Complex Number Multiplication
 * href: https://leetcode.com/problems/complex-number-multiplication/description/ */
public class ComplexNumberMultiplication {
    
    public static String solve(String a, String b){
        Pattern p = Pattern.compile("(-?\\d+)\\+(-?\\d+)i");
        
        Matcher m_a = p.matcher(a);
        m_a.matches();
        Matcher m_b = p.matcher(b);
        m_b.matches();
        
        int real_a = Integer.parseInt( m_a.group(1) );
        int real_b = Integer.parseInt( m_b.group(1) );
        int complex_a = Integer.parseInt( m_a.group(2) );
        int complex_b = Integer.parseInt( m_b.group(2) );
        
        int real_result = real_a*real_b - complex_a*complex_b;
        int complex_result = real_a*complex_b + real_b*complex_a;
        
        return ""+real_result+"+"+complex_result+"i";
    }

    
    @Test
    public void test(){
        assertEquals("0+2i", solve("1+1i", "1+1i"));
        assertEquals("0+-2i", solve("1+-1i", "1+-1i"));
    }
}
