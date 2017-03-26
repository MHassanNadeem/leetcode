package leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/* #19. Remove Nth Node From End of List
 * href: https://leetcode.com/problems/remove-nth-node-from-end-of-list/ */
public class RemoveNthFromEnd {
    
    public static ListNode solve(ListNode head, int n){
        int nodeArrayLen = n+1;
        ListNode[] nodeArray = new ListNode[nodeArrayLen]; /* Circular list to keep last n+1 nodes */
        int listLen = 0;
        ListNode temp = head;
        
        while(temp != null){
            nodeArray[listLen++%(nodeArrayLen)] = temp;
            temp = temp.next;
        }
        
        ListNode nodeToBeDeleted = nodeArray[(listLen+1)%nodeArrayLen];
        ListNode prevNode = nodeArray[(listLen)%nodeArrayLen];

        if( prevNode == null){
            head = head.next;
        }else{
            prevNode.next = nodeToBeDeleted.next;
        }
        
        return head;
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
