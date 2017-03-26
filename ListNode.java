package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    
    ListNode(int value){
        this.val = value;
        this.next = null;
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
    
    public static int[] toArray(ListNode list){
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
}
