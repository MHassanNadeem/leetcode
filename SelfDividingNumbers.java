package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/* #728
 * href: https://leetcode.com/problems/self-dividing-numbers/description/ */
public class SelfDividingNumbers {
    public static boolean isSelfDividing(int num){
        int t = num;
        int digit;
        while(t > 0){
            digit = t%10;
            if( digit == 0 || num%digit != 0 ) return false;
            t /= 10;
        }
        
        return true;
    }
    
    public static int nthDigitFromEnd(int num, int n){
        if(Math.log10(num) < n) return -1;
        return ((int)(num/(Math.pow(10,n)))%10);
    }
    
    public static List<Integer> solve(int left, int right){
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=left; i<=right; i++){
            if(nthDigitFromEnd(i, 1) == 0) i += 10 - i%10;       // XXXX0X
            if(nthDigitFromEnd(i, 2) == 0) i += 100 - i%100;     // XXX0XX
            if(nthDigitFromEnd(i, 3) == 0) i += 1000 - i%1000;   // XX0XXX
            if(nthDigitFromEnd(i, 4) == 0) i += 10000 - i%10000; // X0XXXX
            
            if( isSelfDividing(i) ) {list.add(i); System.out.println(i);}
        }
        
        return list;
    }

    
    @Test
    public void test(){
        assertEquals(4, nthDigitFromEnd(1234,0));
        assertEquals(3, nthDigitFromEnd(1234,1));
        assertEquals(2, nthDigitFromEnd(1234,2));
        assertEquals(1, nthDigitFromEnd(1234,3));
        assertEquals(-1, nthDigitFromEnd(1234,4));
        
        solve(3056, 3132);
    }
}
