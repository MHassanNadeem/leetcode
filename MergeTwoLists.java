package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #21. Merge Two Sorted Lists
 * href: https://leetcode.com/problems/merge-two-sorted-lists/ */
public class MergeTwoLists {
    
    private static void appendAtEnd(ListNode head, ListNode node){
        
    }
    
    public static ListNode solve(ListNode l1, ListNode l2){
        return null;
    }

    
    @Test
    public void test(){
        test(new int[]{1,4,5}, new int[]{2,3});
    }
    
    public void test(int[] l1, int[] l2){
        ListNode l1List = ListNode.arrayToList(l1);
        ListNode l2List = ListNode.arrayToList(l2);
        
        int[] expectedMerged = mergeTwoArrays(l1, l2);
        int[] actualMerged = ListNode.toArray( solve(l1List, l2List) );
        
        System.out.format("Expected: %s\n" ,Arrays.toString( expectedMerged ) );
        System.out.format("Actual:   %s\n", Arrays.toString( actualMerged ) );
        System.out.println("");
        
        assertArrayEquals(expectedMerged, actualMerged);
    }
    
    public static int[] mergeTwoArrays(int[] a, int[] b){
        int aLen = a.length;
        int bLen = b.length;
        int[] c= new int[aLen+bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        
        Arrays.sort(c);
        
        return c;
     }
}
