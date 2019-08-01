package OddEvenList;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode end = head.next;
        ListNode p = head;
        while(end!=null&&end.next!=null){
            ListNode m = end.next;
            ListNode r = p.next;

            p.next = m;        //step 1
            end.next=m.next;  //step 2
            m.next=r;         //step 3

            p = p.next;
            end = end.next;
        }
        return head;
    }
}
