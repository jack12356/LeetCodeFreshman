package ListNode;

public class ReverseListNodeK {
    public static void main(String []args){
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode head = ListNode.createListNodeFromNums(nums);
        head.showList();
        int K = 2;
        ListNode p = reverseKGroup(head, K);
        p.showList();
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k<=1) return head;
        ListNode st = new ListNode(-1);
        st.next = head;
        ListNode pre = st;
        ListNode p = head;

        int cnt = 0;
        while(p!=null){
            p = p.next;
            cnt++;
        }

        while (cnt>=k){
            for (int i = 0; i < k - 1; i++) {
                ListNode preNext = pre.next;
                pre.next = head.next;
                head.next = pre.next.next;
                pre.next.next = preNext;
            }
            pre = head;
            head = head.next;
            cnt -= k;
        }
        return st.next;

    }
}
