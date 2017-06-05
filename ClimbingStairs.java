package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #70. Climbing Stairs
 * href: https://leetcode.com/problems/climbing-stairs/#/description */
public class ClimbingStairs {
    
    /* O(n) solution */
    public static int solve(int n){
        if(n < 3) return n;
        
        /* n is >= 3 beyond this point */
        
        int sol_n_minus_1 = 2; /* solution for n = 2 */
        int sol_n_minus_2 = 1; /* solution for n = 1 */
        int solution = 0;
        
        for(int i=3; i<=n; i++){
            solution = sol_n_minus_1 + sol_n_minus_2;
            sol_n_minus_2 = sol_n_minus_1;
            sol_n_minus_1 = solution;
        }
        
        return solution;
    }
    
    /* --------------------------------------------------- */
    /* Correct solution for small input values             */
    /* --------------------------------------------------- */
    public static long factorial(int n){
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    
    public static int combinations(int n, int r){
        if(r>n-r) r = n-r;
        long temp = 1; /*  (n) x (n-1) x ... x (n-r+1) */
        
        for(int i=n; i>(n-r); i--){
            temp *= i;
        }
        
        return (int) (temp/factorial(r));
    }
    
    /* O(n^2) solution. Only works for small n */
    public static int solve_(int n){
        int result = 0;
        int maxNumTwos = n/2;
        
        for(int numTwos=maxNumTwos; numTwos>=0; numTwos--){
            int numOnes = n - 2*numTwos;
            result += combinations(numOnes+numTwos, numTwos);
        }
        
        return result;
    }

    
    @Test
    public void test(){
        assertEquals(1, solve(1));
        assertEquals(2, solve(2));
        assertEquals(3, solve(3));
        assertEquals(5, solve(4));
        
        assertEquals(14930352, solve(35));
        assertEquals(1134903170, solve(44));
    }
    
    @Test
    public void testCombinations(){
        assertEquals(1,  combinations(5, 0));
        assertEquals(5,  combinations(5, 1));
        assertEquals(10, combinations(5, 2));
        assertEquals(10, combinations(5, 3));
        assertEquals(5,  combinations(5, 4));
        assertEquals(1,  combinations(5, 5));
        
        assertEquals(15504,  combinations(20, 5));
        
        assertEquals(536878650,  combinations(50, 8));
        
        assertEquals(1101716330,  combinations(46, 9));
        
        assertEquals(10626,  combinations(24, 20));
    }
}
