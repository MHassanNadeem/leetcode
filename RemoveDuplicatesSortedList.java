package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #83. Remove Duplicates from Sorted List
 * href: https://leetcode.com/problems/remove-duplicates-from-sorted-list/#/description */
public class RemoveDuplicatesSortedList {
    
    public static ListNode solve(ListNode head){
        ListNode node = head;

        while(node != null && node.next != null){
            if(node.next.val == node.val){
                /* delete node.next */
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        
        return head;
    }

    
    @Test
    public void test(){
        test(new int[]{}, new int[]{});
        test(new int[]{0}, new int[]{0});
        test(new int[]{0}, new int[]{0, 0});
        test(new int[]{0}, new int[]{0, 0, 0});
        
        test(new int[]{0,1}, new int[]{0, 0, 0, 1});
        test(new int[]{0,1}, new int[]{0, 0, 0, 1, 1});
        test(new int[]{0,1,2}, new int[]{0, 0, 0, 1, 2});
        
        test(new int[]{0,1,2}, new int[]{0, 1, 2});
    }
    
    public void test(int[] expected, int[] input){
        ListNode head = ListNode.arrayToList( input );
        int[] solution = ListNode.toArray( solve(head) );
        
        assertArrayEquals(expected, solution);
    }
}
