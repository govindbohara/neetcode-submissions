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
        if(head == null || k==1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;
        while(true){
            ListNode first = groupPrev.next;
            ListNode kth = groupPrev;
            for(int i =0; i<k; i++){
                kth = kth.next;
                if(kth == null) return dummy.next;
            }
            ListNode second = kth.next;
            kth.next = null;
            ListNode curr = first;
            ListNode prev = null;
            while(curr != null){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            groupPrev.next = prev;
            first.next = second;
            groupPrev = first;
        }
        
    }
}
