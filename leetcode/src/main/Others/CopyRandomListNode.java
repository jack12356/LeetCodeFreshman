package Others;

import java.util.Comparator;

class RanDomListNode{
    int val;
    RanDomListNode next;
    RanDomListNode random;
    RanDomListNode(int v){
        val = v;
    }
}

public class CopyRandomListNode {
    public RanDomListNode copy(RanDomListNode head) {
        if(head==null) return null;
        RanDomListNode p = head;
        // copy node
        while (p!=null){
            RanDomListNode pnext = p.next;
            p.next = new RanDomListNode(p.val);
            p = p.next;
            p.next = pnext;
            p = p.next;
        }
        // copy random
        p = head;
        while (p!=null){
            RanDomListNode prandom = p.random;
            if(prandom!=null) {
                p.next.random = prandom.next;
            }
            p = p.next.next;
        }
        // redirect node
        p = head;
        RanDomListNode chead = p.next;
        RanDomListNode q = chead;
        while (p!=null){
            p.next = p.next.next;
            q.next = q.next.next;
            p = p.next;
            q = q.next;
        }
        return chead;
    }

}
