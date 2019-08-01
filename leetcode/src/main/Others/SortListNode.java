public class SortListNode {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 7, 1, 13, 24, 14, 9, 21};
        ListNode head = ListNode.createListNodeFromNums(nums);
        qSort(head,null);
        head.showList();
    }

    private static void qSort(ListNode head,ListNode end) {
        ListNode small = head;
        ListNode cur = head.next;
        while (cur != end) {
            if (cur.val < head.val) {
                small = small.next;
                int t = cur.val;
                cur.val = small.val;
                small.val = t;
            }
            cur = cur.next;
        }
        int t = small.val;
        small.val = head.val;
        head.val = t;
        if (small.next != end) {
            qSort(small.next, end);
        }
        if(head!=small){
            qSort(head, small);
        }

    }
}
