package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Random;
import java.util.Arrays;

/* #382. Linked List Random Node
 * href: https://leetcode.com/problems/linked-list-random-node/#/description */
public class LinkedListRandomNode {
    
    public class Solution {
        ListNode head;
        Random rand;
        
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            rand = new Random();
        }
        
        /** Returns a random node's value. */
        public int getRandom(){
            ListNode selected = head;
            ListNode t = head;
            int i = 0;
            
            while(t != null){
                i++;
                
                if(rand.nextInt(i) == 0){ /* probability of 1/i */
                    selected = t;
                }
                
                t = t.next;
            }
            
            return selected.val;
        }
    }

    
    @Test
    public void test_getRandom(){
        final int NUM_EXPERIMENTS = 1000000;
        final int LIST_SIZE = 15;
        final double IDEAL_PROB = (double)1/LIST_SIZE;
        final double MAX_ERROR = IDEAL_PROB*0.05; /* 5% */
        int[] array = new int[LIST_SIZE];
        int[] freq  = new int[LIST_SIZE];
        double[] prob  = new double[LIST_SIZE];
        
        /* Fill list with range 0 to LIST_SIZE */
        for(int i=0; i<LIST_SIZE; i++){
            array[i] = i;
        }
        
        ListNode head = ListNode.arrayToList(array);
        Solution sol = new Solution(head);
        
        for(int i=0; i<NUM_EXPERIMENTS; i++){
            freq[sol.getRandom()]++;
        }
        
        /* Calculate probabilities and validate error */
        for(int i=0; i<LIST_SIZE; i++){
            prob[i] = (double)freq[i]/NUM_EXPERIMENTS;
            assertTrue(Math.abs(prob[i] - IDEAL_PROB) < MAX_ERROR);
        }
    }
}
