package PalindromeList21;

import ListNode.ListNode;

public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        ListNode pre=head;
        ListNode last=head;
        while(last.next!=null&&last.next.next!=null){
            pre=pre.next;
            last=last.next.next;
        }
        //翻转后半部分
        ListNode cur=pre.next;
        pre.next=null;
        ListNode s=null;
        ListNode t=cur;
        while(cur!=null){
            t=cur;
            cur=cur.next;
            t.next = s;
            s=t;
        }
        while(s!=null&&head!=null){
            if(s.val!=head.val)
                return false;
            head=head.next;
            s=s.next;
        }

        return true;
    }
}
