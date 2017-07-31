package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int value){
        this.val = value;
        this.right = this.left = null;
    }
    
    public static void printInorder(TreeNode root){
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.val);
            printInorder(root.right);
        }
    }
    
    public static TreeNode insert(TreeNode root, int val){
        if(root == null) return new TreeNode( val );
        
        if (val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        
        return root;
    }
    
    public static TreeNode arrayToBST(int[] array){
        TreeNode root = null;
        
        for(int n:array){
            root = insert(root, n);
        }
        
        return root;
    }
}
