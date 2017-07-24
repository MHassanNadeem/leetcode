package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #171. Excel Sheet Column Number
 * href: https://leetcode.com/problems/excel-sheet-column-number/#/description */
public class ExcelSheetColumnNumber {
    
    public static int solve(String s){
        int num = 0;
        
        for(char c:s.toCharArray()){
            num = num*26 + (1+c-'A');
        }
        
        return num;
    }

    
    @Test
    public void test(){
        assertEquals(1, solve("A"));
        assertEquals(26, solve("Z"));
        assertEquals(27, solve("AA"));
        assertEquals(28, solve("AB"));
    }
}
