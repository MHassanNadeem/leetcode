package leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/* #11. Container With Most Water
 * href: https://leetcode.com/problems/container-with-most-water/ */
public class ContainerWithMostWater {
    
    /* Area = min(ax, ay) * abs(ix-iy) */
    public static int solve(int[] height){
        int maxArea = 0;
        
        int a = 0, b = height.length - 1;
        
        while(a<b){
            int newArea = (b-a) * Integer.min(height[a], height[b]);
            maxArea = Integer.max(maxArea, newArea);
            
            if(height[a] < height[b]){
                a++;
            }else{
                b--;
            }
        }
        
        return maxArea;
    }
    
    public static int bruteForce(int[] height){
        int maxArea = 0;
        for(int i=0; i<height.length; i++){
            for(int j=i+1; j<height.length; j++){
                int newArea = (j-i) * Integer.min(height[i], height[j]);
                maxArea = Integer.max(maxArea, newArea);
            }
        }
        
        return maxArea;
    }

    
    @Test
    public void test(){
        final Random rand = new Random();
        final int TEST_COUNT = 10000;
        
        for(int i=0; i<TEST_COUNT; i++){
            int randomSize = rand.nextInt( 100 );
            int[] randomArray = getRandomArray( randomSize );
            
            assertEquals(bruteForce(randomArray), solve(randomArray));
        }
    }
    
    public static int[] getRandomArray(int size){
        final Random rand = new Random();
        int[] array = new int[size];
        
        for(int i=0; i<size; i++){
            array[i] = rand.nextInt( 100 );
        }
        
        return array;
    }
}
