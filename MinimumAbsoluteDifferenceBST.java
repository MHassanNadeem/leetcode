package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #530. Minimum Absolute Difference in BST
 * href: https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/ */
public class MinimumAbsoluteDifferenceBST {
    Integer min = Integer.MAX_VALUE;
    Integer prev = null;
    
    public int solve(TreeNode root){
        if(root == null) return min;
        
        solve(root.left);
        
        if(prev != null) min = Math.min(min, root.val - prev);
        prev = root.val;
        
        solve(root.right);

        return min;
    }

    
    @Test
    public void test(){
        assertEquals(1, new MinimumAbsoluteDifferenceBST().solve(TreeNode.arrayToBST(new int[]{1, 3, 2})));
        assertEquals(0, new MinimumAbsoluteDifferenceBST().solve(TreeNode.arrayToBST(new int[]{1,1,3,2})));
        assertEquals(0, new MinimumAbsoluteDifferenceBST().solve(TreeNode.arrayToBST(new int[]{1,3,3,2})));
        assertEquals(0, new MinimumAbsoluteDifferenceBST().solve(TreeNode.arrayToBST(new int[]{1,3,2,2})));
        assertEquals(9, new MinimumAbsoluteDifferenceBST().solve(TreeNode.arrayToBST(new int[]{236, 104, 701, 227, 911})));
    }
}
