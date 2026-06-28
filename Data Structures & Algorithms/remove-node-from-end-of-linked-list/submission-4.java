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
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = reverse(head);

        if(n==1){
            return reverse(head.next);
        }
        ListNode curr = head;
        for(int i = 1; i<n-1; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;



        return reverse(head);

        

    }
}
