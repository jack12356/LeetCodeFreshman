import java.util.ArrayList;
import java.util.Collections;

public class SortList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode i=l1;
        ListNode j = l2;
        ListNode s0=new ListNode(-1);
        ListNode s=s0;
        while(i!=null && j!=null){
            if(i.val<j.val){
                s.next=i;
                i=i.next;
                s=s.next;
            }else{
                s.next=j;
                j=j.next;
                s=s.next;
            }
        }
        s.next = i == null ? j : i;
        return s0.next;
    }
    public ListNode sortList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        return mergeTwoLists(sortList(head),sortList(second));
    }
}
