package GetIntersectionNode;

import ListNode.ListNode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        int countA=0,countB=0;
        while (l1!=null) {
            countA++;
            l1=l1.next;
        }
        while (l2!=null) {
            countB++;
            l2=l2.next;
        }
        l1=headA;
        l2=headB;
        while (countA!=countB){
            if (countA>countB){
                countA--;
                l1=l1.next;
            }else {
                countB--;
                l2=l2.next;
            }
        }
        while (l1!=null&&l2!=null&&l1!=l2){
            l1=l1.next;
            l2=l2.next;
        }
        return l1;
    }

    public static void main(String[] args) {
        GetIntersectionNode solution = new GetIntersectionNode();
        ListNode headA = ListNode.createListNodeFromNums(new int[]{0,7,1});
        ListNode headB = new ListNode(3);
//        ListNode t = ListNode.createListNodeFromNums(new int[]{2});
//        headA.next.next.next=t;
//        headB.next=t;
        headA.showList();
        headB.showList();
        solution.getIntersectionNode(headA,headB).showList();
    }
}
