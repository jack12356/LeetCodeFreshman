package DeleteListNodeN;

import DeleteNodeList.DeleteNodeList;
import ListNode.ListNode;

public class DeleteListNodeN {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s0 = new ListNode(-1);
        s0.next = head;
        ListNode s=s0;
        ListNode e = s;
        for (int i = 0; i < n; i++) {
            e = e.next;
        }
        while(e.next!=null){
            s=s.next;
            e=e.next;
        }
        //删除s后面一个节点
        s.next = s.next.next;
        return s0.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        DeleteListNodeN solution = new DeleteListNodeN();
        ListNode l2 = solution.removeNthFromEnd(l1,1);
    }
}
