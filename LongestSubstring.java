package leetcode;

import java.util.HashMap;

/* #3 Longest Substring Without Repeating Characters
 * href: https://leetcode.com/problems/longest-substring-without-repeating-characters/ */
public class LongestSubstring {

    public static int solve(String s){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        int startIndex = 0;
        int endIndex = 0;
        int maxLen = 0;
        
        if(s.length() == 1) return 1;
        
        while(endIndex < s.length()){
            Integer dupIndex = map.get( s.charAt(endIndex) );
            if( dupIndex!=null && dupIndex >= startIndex){
                maxLen = Math.max(maxLen, (endIndex - startIndex));
                startIndex = 1 + dupIndex;
            }
            
            map.put(s.charAt(endIndex), endIndex);
            endIndex++;
        }
        
        maxLen = Math.max(maxLen, (endIndex - startIndex));
        return maxLen;
    }
    
    public static void main(String[] args) {
        System.out.println( solve("abcabcbb") ); /* 3 */
        System.out.println( solve("pwwkew") );   /* 3 */
        System.out.println( solve("a") );        /* 1 */
        System.out.println( solve("abba") );     /* 2 */
        System.out.println( solve("au") );      /* 2 */
    }

}
