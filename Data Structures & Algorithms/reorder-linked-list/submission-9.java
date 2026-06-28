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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode curr = slow.next;
        ListNode prev = null;
        slow.next = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }


        ListNode first = head;
        curr = prev;

        while(curr != null){
            ListNode temp1 = first.next;
            ListNode temp2 = curr.next;

            first.next = curr;
            curr.next = temp1;

            first = temp1;
            curr = temp2;
            
        }

        
        
    }
}
