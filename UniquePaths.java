package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

/* #62. Unique Paths
 * href: https://leetcode.com/problems/unique-paths/#/description */
public class UniquePaths {
    
    /*-------------------------------------------------------------*/
    /* O(n*m) solution. */
    public int solve(int m, int n){
        Integer[][] map = new Integer[m][n];
        
        for(int i = 0; i< m; i++) map[i][0] = 1;
        for(int i = 0; i< n; i++) map[0][i] = 1;
        
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }
        
        return map[m-1][n-1];
    }
    /*-------------------------------------------------------------*/
    
    
    /*-------------------------------------------------------------*/
    /* O(n*m) solution not accepted. Time limit reached. */
    HashMap<Point, Integer> path=new HashMap<>();
    public int solve_recursive(int m, int n){
        Point p = new Point(m,n);
        if(path.containsKey(p)) return path.get(p);
        if(m == 1 || n == 1) return 1;
        
        int sol = solve_recursive(m-1, n) + solve_recursive(m, n-1);
        path.put(p, sol);
        
        return sol;
    }
    /*-------------------------------------------------------------*/

    
    @Test
    public void test(){
        assertEquals(2, solve(2,2));
        assertEquals(3, solve(2,3));
        assertEquals(3, solve(3,2));
        
        assertEquals(solve_recursive(23,12), solve(23,12));
    }
}
