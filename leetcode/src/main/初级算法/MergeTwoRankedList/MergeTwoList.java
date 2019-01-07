package MergeTwoRankedList;

import ListNode.ListNode;


public class MergeTwoList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode i=l1;
        ListNode j = l2;
        ListNode s0=new ListNode(-1);
        ListNode s=s0;
        while(i!=null && j!=null){
            if(i.val<j.val){
                s.next=i;
                i=i.next;
                s=s.next;
            }else{
                s.next=j;
                j=j.next;
                s=s.next;
            }
        }
        if(i==null){
            s.next=j;
        }else{
            s.next=i;
        }
        return s0.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(3);
        l1.next.next=new ListNode(4);
        l1.showList();
        ListNode l2=new ListNode(0);
        l2.next=new ListNode(2);
        l2.next.next=new ListNode(5);
        l2.showList();
        MergeTwoList solution = new MergeTwoList();
        ListNode so = solution.mergeTwoLists(l1,l2);
        so.showList();
    }
}



