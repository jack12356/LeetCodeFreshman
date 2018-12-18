package ReverseList;

import ListNode.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode newhead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newhead;
    }
}
