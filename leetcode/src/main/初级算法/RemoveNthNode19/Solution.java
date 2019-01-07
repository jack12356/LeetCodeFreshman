package RemoveNthNode19;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy.next;
        ListNode last = dummy.next;
        for (int i = 0; i < n - 1; i++) {
            first = first.next;
        }
        while (first != null) {
            last=last.next;
            first = first.next;
        }
        last.next=last.next.next;
        return dummy.next;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next=new ListNode(4);
        System.out.println(solution.removeNthFromEnd(l1, 2));
    }
}
