package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

/* #592. Fraction Addition and Subtraction
 * href: https://leetcode.com/problems/fraction-addition-and-subtraction/#/description */
public class FractionAdditionSubtraction {
    
    public class Fraction{
        int numerator, denominator, sign;
        
        public Fraction(int sign, int numerator, int denominator){
            this.numerator   = sign*numerator;
            this.denominator = denominator;
        }
        
        @Override
        public String toString(){
            return String.valueOf(numerator) + "/" + String.valueOf(denominator);
        }
        
        public Fraction simplify(){
            int divisor = gcd(Math.abs(numerator), denominator);
            numerator /= divisor;
            denominator /= divisor;
            return this;
        }
        
        public Fraction add(Fraction f2){
            Fraction f1 = this;
            
            numerator = f1.numerator * f2.denominator + f2.numerator * f1.denominator;
            denominator = f1.denominator*f2.denominator;
            simplify();
            
            return f1;
        }
    }
    
    public static int gcd(int x, int y){
        if(x == 0 || y == 0){
            return x+y;
        }
        
        return gcd(y, x % y);
    }
    
    public String solve(String exp){
        /* (([\+\-]{0,1})(\d+)\/(\d+)) */
        final String PATTERN = "(([\\+\\-]{0,1})(\\d+)\\/(\\d+))";
        final int GROUP_SIGN = 2;
        final int GROUP_NUMERATOR = 3;
        final int GROUP_DENOMINATOR = 4;
        final Pattern R = Pattern.compile(PATTERN);
        
        Matcher m = R.matcher(exp);
        
        Fraction ans = new Fraction(1, 0, 1); /* 0/1 = 0 */
        
        while(m.find()){
            int sign = m.group(GROUP_SIGN).equals("-")?-1:1;
            int numerator = Integer.parseInt(m.group(GROUP_NUMERATOR));
            int denominator = Integer.parseInt(m.group(GROUP_DENOMINATOR));
            ans.add( new Fraction(sign, numerator, denominator) );
        }

        return ans.simplify().toString();
    }

    
    @Test
    public void test(){
        assertEquals("1/1", solve("1/1"));
        assertEquals("2/1", solve("2/1"));
        assertEquals("-2/1", solve("-2/1"));
        assertEquals("-2/1", solve("0/1-2/1"));
        
        assertEquals("0/1", solve("-1/2+1/2"));
        assertEquals("1/3", solve("-1/2+1/2+1/3"));
        assertEquals("-1/6", solve("1/3-1/2"));
        assertEquals("2/1", solve("5/3+1/3"));
    }
}
