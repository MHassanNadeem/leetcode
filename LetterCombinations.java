package leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* #17. Letter Combinations of a Phone Number
 * href: https://leetcode.com/problems/letter-combinations-of-a-phone-number/ */
public class LetterCombinations { 
    
    private static HashMap<Character, Character[]> map = new HashMap<>();
    static{
        map.put('0', new Character[]{'0'});
        map.put('1', new Character[]{'1'});
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }

    public List<String> solve(String digits){
        List<String> list = new ArrayList<>();
        
        if(digits.length() == 0) return list;
        
        list.add("");
        
        for(int i = 0; i<digits.length(); i++){
            List<String> temp = new ArrayList<>();
            for(Character c:map.get( digits.charAt(i) )){
                for(String str: list){
                    temp.add( new String(str + c) );
                }
            }
            list = temp;
        }
        
        return list;
    }

    
    @Test
    public void test(){
        System.out.println( solve("23") );
    }

}
