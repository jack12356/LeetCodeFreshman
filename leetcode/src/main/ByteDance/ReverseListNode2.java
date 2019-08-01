public class ReverseListNode2 {
    // 1->2->3->4->5->6
    // 5->6->3->4->1->2
    public static void main(String[] args) {
        ListNode head = ListNode.createListNodeFromNums(new int[]{1, 2, 3, 4, 5});
        ListNode res = reverse2node(head);
        res.showList();
    }

    private static ListNode reverse2node(ListNode head) {
        ListNode st = new ListNode(-1);
        st.next = head;
        if(head==null||head.next==null||head.next.next==null) return head;
        ListNode pst = head;
        ListNode pend = head.next;
        ListNode nst = head.next.next;
        pend.next=null;
        while (nst != null && nst.next != null) {
            ListNode nend = nst.next;
            ListNode t = nst;

            nst = nend.next;
            nend.next = pst;

            pst = t;
        }
        if(nst!=null){
            nst.next = pst;
            pst = nst;
        }
        st.next = pst;

        return st.next;
    }
}
