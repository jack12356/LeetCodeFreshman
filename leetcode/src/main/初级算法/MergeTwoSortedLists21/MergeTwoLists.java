package MergeTwoSortedLists21;

/**
 * 合并两个排好序的链表，并返回这个新链表。
 新链表应该由这两个链表的头部拼接而成。
 */

public class MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode Merge(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode rst = new ListNode(0);
        ListNode last = new ListNode(0);
        rst.next = last;
        while (l1!= null && l2!= null) {
            if (l1.val <= l2.val) {
                last.next = l1;
                last = last.next;
                if (l1.next==null) {last.next=l2; return rst.next.next;}
                l1 = l1.next;
            } else {
                last.next = l2;
                last = last.next;
                if (l2.next==null) {last.next=l1; return rst.next.next;}
                l2 = l2.next;
            }
        }
        return rst.next.next;
    }

    public ListNode MergeByRecur(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode rst = new ListNode(0);
        rst.next = (l1.val <= l2.val)?l1:l2;    ListNode temp = (l1.val > l2.val)?l1:l2;
        rst.next.next = MergeByRecur(rst.next.next, temp);
        return rst.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(8);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(7);
        MergeTwoLists merge = new MergeTwoLists();
//        ListNode l1 = null;
//        ListNode l2 = null;
//        ListNode res = merge.Merge(l1, l2);
        ListNode res = merge.MergeByRecur(l1, l2);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}
