package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

/* #20 Valid Parentheses
 * href: https://leetcode.com/problems/valid-parentheses/ */
public class ValidParentheses {
    public static boolean solve(String s){
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        
        Stack<Character> stack = new Stack();
        
        for(char c:s.toCharArray()){
            if(map.containsKey(c)){ /* is opening bracket */
                stack.push(c);
            }else{
                if(map.containsValue(c)){ /* is closing bracket */
                    if(stack.isEmpty() || map.get( stack.pop() ) != c){
                        return false;
                    }
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    @Test
    public void test(){
        assertEquals(false, solve(")"));
        assertEquals(false, solve("("));
        assertEquals(false, solve("([)]"));
        assertEquals(false, solve("(("));
        assertEquals(false, solve("(]"));
        assertEquals(true, solve("()"));
        assertEquals(true, solve("([])"));
    }
}
