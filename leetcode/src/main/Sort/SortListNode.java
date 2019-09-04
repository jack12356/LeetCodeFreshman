package Sort;

public class SortListNode {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 7, 1, 13, 24, 14, 9, 21};
        ListNode head = ListNode.createListNodeFromNums(nums);
//        quciSort(head,null);
        MergeSort(head);
        head.showList();
    }

    private static void quickSort(ListNode head, ListNode end) {
        if(head==end) return;
        ListNode small = head;
        ListNode cur = head.next;
        while (cur != end) {
            if (cur.val < head.val) {
                small = small.next;             // 更改small.next，所以small.next指向第一个大于head的数，最后更改small和head
                int t = cur.val;
                cur.val = small.val;
                small.val = t;
            }
            cur = cur.next;
        }
        int t = small.val;
        small.val = head.val;
        head.val = t;
        quickSort(small.next, end);
        quickSort(head, small);
    }

    private static ListNode MergeSort(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rst = slow.next;
        slow.next = null;
        ListNode left = MergeSort(head);
        ListNode rt = MergeSort(rst);
        return Merge(left, rt);
    }

    private static ListNode Merge(ListNode left, ListNode rt) {
        ListNode st = new ListNode(-1);
        ListNode pre = st;
        while (left != null && rt != null) {
            if(left.val<rt.val) {
                pre.next = left;
                left = left.next;
            }else {
                pre.next = rt;
                rt = rt.next;
            }
            pre = pre.next;
        }
        pre.next = rt == null ? left : rt;
        return st.next;
    }
}
