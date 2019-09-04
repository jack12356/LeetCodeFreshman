package ListNode;

public class MoveOdd {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        ListNode head = ListNode.createListNodeFromNums(nums);
        head = moveOdd(head);
        head.showList();
    }

    public static ListNode moveOdd(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //保存头节点
        ListNode st = head;
        ListNode end = head.next;


        //保存第一个odd even节点
        ListNode odd = head;
        ListNode even = head.next;
        while (even != null && even.next != null) {
            //依次将奇数节点链接起来
            odd.next = odd.next.next;
            odd = odd.next;
            //依次将偶数节点链接起来
            even.next = even.next.next;
            even = even.next;
        }
        //将第一个偶数节点链接到最后一个奇数节点的后面
        odd.next = end;
        return st;
    }
}
