package ListNode;

public class ReverseNode {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode head = ListNode.createListNodeFromNums(nums);
        head.showList();
        ListNode res = reverse1(head);
        res.showList();
    }

    private static ListNode reverse(ListNode head) {
        ListNode st = new ListNode(-1);
        st.next = head;
        ListNode pSt = head;
        ListNode pNSt = pSt.next;
        pSt.next = null;
        while (pNSt!=null){
            ListNode pNEnd = pNSt.next;
            pNSt.next = pSt;

            pSt = pNSt;
            pNSt = pNEnd;
        }
        st.next = pSt;
        return st.next;
    }

    private static ListNode reverse1(ListNode head) {
        ListNode st = new ListNode(-1);
        st.next = head;
        while(head.next!=null){
            ListNode t = st.next;
            st.next = head.next;
            head.next = st.next.next;
            st.next.next = t;
        }
        return st.next;
    }
}
