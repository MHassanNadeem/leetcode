package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* #412 Fizz Buzz
 * href: https://leetcode.com/problems/fizz-buzz/ */
public class FizzBuzz {

    public static List<String> solve(int n){
        List<String> list = new ArrayList<String>();
        
        for(int i=1; i<=n; i++){
            if(i%15 == 0){
                list.add("FizzBuzz");
            }else if(i%5 == 0){
                list.add("Buzz");
            }else if(i%3 == 0){
                list.add("Fizz");
            }else{
                list.add( Integer.toString(i) );
            }
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println( Arrays.toString( solve(20).toArray() ) );
    }

}
