package leetcode;

import java.util.*;

/* #2 Add Two Numbers
 * href: https://leetcode.com/problems/add-two-numbers/ */
public class AddTwoNumbers {

    public static class ListNode{
        int val;
        ListNode next;
        
        ListNode(int value){
            this.val = value;
            this.next = null;
        }
    }
    
    public static ListNode arrayToList(int[] array){
        /* head with dummy first node */
        ListNode head = new ListNode(0);
        ListNode t = head;
        
        for(int i = 0; i<array.length; i++){
            t.next = new ListNode( array[i] );
            t = t.next;
        }
        
        return head.next;
    }
    
    public static int[] listToArray(ListNode list){
        List<Integer> arrayList = new ArrayList<Integer>();
        
        while(list!=null){
            arrayList.add( list.val );
            list = list.next;
        }
        
        int[] array = new int[arrayList.size()];
        
        for(int i=0; i<arrayList.size(); i++){
            array[i] = arrayList.get(i);
        }
        
        return array;
    }
    
    public static ListNode solve(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0); /* Dummy head */
        ListNode prevNode = head;
        int val1, val2;
        int carry = 0;
        int sum;
        
        while(l1!=null || l2!=null || carry!=0){
            if(l1!=null){
                val1 = l1.val;
                l1 = l1.next;
            }else{
                val1 = 0;
            }
            
            if(l2!=null){
                val2 = l2.val;
                l2 = l2.next;
            }else{
                val2 = 0;
            }
            
            sum = val1 + val2 + carry;
            carry = sum/10;
            
            prevNode.next = new AddTwoNumbers.ListNode( sum%10 );
            prevNode = prevNode.next;
        }
        
        return head.next;
    }
    
    public static void main(String[] args) {
        int[] n1 = new int[]{0, 0, 2, 4, 3};
        int[] n2 = new int[]{5, 6, 4};
        
        ListNode l1 = arrayToList(n1);
        ListNode l2 = arrayToList(n2);
        
        System.out.println( Arrays.toString( listToArray(solve(l1, l2)) ) );;
    }

}
