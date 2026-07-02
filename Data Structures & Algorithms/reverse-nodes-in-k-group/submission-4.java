/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode first= head;
        ListNode second= first;

        ListNode curr = first;

        for(int i=0; i<k-1;i++){
            if(first ==null && first.next==null)return head;
            first = first.next;
        }
        second = first.next;
        first.next = null;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        int count = 0;
        ListNode scurr = second;
        while(scurr != null){
            scurr = scurr.next;
            count++;
        } 
        if(count < k){
            head.next = second;
            
        }else{
            head.next = reverseKGroup(second,k);
            
        }
        return prev;
    }
}
