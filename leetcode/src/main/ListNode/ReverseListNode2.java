package ListNode;

public class ReverseListNode2 {
    // 1->2->3->4->5->6
    // 5->6->3->4->1->2
    public static void main(String[] args) {
        ListNode head = ListNode.createListNodeFromNums(new int[]{1, 2, 3, 4, 5,6,7,8,9});
        head.showList();
        ListNode res = reverse2Node(head);
        res.showList();
    }


    private static ListNode reverse2Node(ListNode head){
        ListNode st = new ListNode(-1);
        st.next = head;
        ListNode pre = st;
        ListNode p = head;
        int cnt = 0;
        while(p!=null){
            cnt++;
            p = p.next;
        }
        while(cnt>=2){
            for (int i = 0; i < 1; i++) {
                ListNode t = pre.next;
                pre.next = head.next;
                head.next = pre.next.next;
                pre.next.next = t;
            }
            pre = head;
            head = head.next;
            cnt -= 2;
        }
        return st.next;
    }
}
