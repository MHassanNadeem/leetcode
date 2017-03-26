package leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/* #19. Remove Nth Node From End of List
 * href: https://leetcode.com/problems/remove-nth-node-from-end-of-list/ */
public class RemoveNthFromEnd {
    
    public static ListNode solve(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode p1 = dummy, p2 = dummy;
        
        /* Move p1 to nth element */
        for(int i=0; i<=n; i++){
            p1 = p1.next;
        }
        
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        
        /* Delete (L-n)th element = p2.next */
        p2.next = p2.next.next;
        
        return dummy.next;
    }

    
    @Test
    public void test(){
        /* Delete from middle */
        test(new int[]{1,2,3,5}, new int[]{1,2,3,4,5}, 2);
        
        /* Delete from start */
        test(new int[]{1,2,3,4}, new int[]{1,2,3,4,5}, 1);
        
        /* Delete from end */
        test(new int[]{2,3,4,5}, new int[]{1,2,3,4,5}, 5);
        
        /* Delete single element list */
        test(new int[]{}, new int[]{0}, 1);
        
        /* Leetcode failure case */
        test(new int[]{1,2,3,5,6,7,8,9,10}, new int[]{1,2,3,4,5,6,7,8,9,10}, 7);
    }
    
    public void test(int[] expectedArray, int[] inputArray, int inputN){
        ListNode inputList = ListNode.arrayToList(inputArray);
        ListNode actualList = solve(inputList, inputN);
        int[] actualArray = ListNode.toArray(actualList);
        
        assertArrayEquals(expectedArray, actualArray);
    }
}
