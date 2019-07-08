public class Reverse2ListNode {
    public static void main(String[] args) {
        ListNode head = ListNode.createListNodeFromNums(new int[]{1,2,3,4});
        Reverse2ListNode test = new Reverse2ListNode();
        test.solve(head).showList();
    }

    private ListNode solve(ListNode head) {
        ListNode st = new ListNode(-1);
        st.next = head;
        ListNode p = st;
        while (p != null) {
            if(p.next==null||p.next.next==null){
                break;
            }
            ListNode n1 = p.next;
            ListNode n2 = n1.next;
            ListNode p2 = n2.next;
            p.next = n2;
            n1.next = p2;
            n2.next = n1;

            p = n1;
        }
        return st.next;
    }
}
