package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #21. Merge Two Sorted Lists
 * href: https://leetcode.com/problems/merge-two-sorted-lists/ */
public class MergeTwoLists {
    
    public static ListNode solve(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode tail = dummyHead;
        
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        tail.next = l1!=null?l1:l2;
        
        return dummyHead.next;
    }

    
    @Test
    public void test(){
        /* Empty List */
        test(new int[]{1,2,3}, new int[]{});
        test(new int[]{}, new int[]{1,2,3});
        test(new int[]{}, new int[]{});
        
        /* Single Element List */
        test(new int[]{4}, new int[]{1,2,3});
        test(new int[]{1,2,3}, new int[]{4});
        test(new int[]{1}, new int[]{2});
        test(new int[]{2}, new int[]{1});
        
        /* Normal */
        test(new int[]{1,4,5}, new int[]{2,3});
        test(new int[]{1,2,3,5}, new int[]{4,6});
        test(new int[]{1,1,1,1,1,2,2,2,2,4,4,4,4}, new int[]{1,2,3,4,5,6});
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
