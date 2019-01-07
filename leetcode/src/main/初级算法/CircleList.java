import ListNode.ListNode;

public class CircleList {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(slow!=null&&fast!=null){
            slow=slow.next;
            fast=fast.next;
            if(fast!=null)
                fast=fast.next;
            if(slow==fast&&slow!=null)
                return true;
        }
        return false;
    }
}
