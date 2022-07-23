/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Constraints:
    The number of nodes in the list is sz.
    1 <= sz <= 30
    0 <= Node.val <= 100
    1 <= n <= sz
*/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //iterate to end, tracking n spaces behind
        ListNode firstNode = head;
        ListNode delete = head;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        if(head == null) return firstNode.next; //handle the edge case: deleteing the first value    
        while (head.next != null) {
            head = head.next;
            delete = delete.next;
        }
        delete.next = delete.next.next;
        return firstNode;
    }
}
