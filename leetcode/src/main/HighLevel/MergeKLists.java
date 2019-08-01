import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MergeKLists {
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
        s.next = i == null ? j : i;
        return s0.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) return null;
        LinkedList<ListNode> queue = new LinkedList<>(Arrays.asList(lists));
        while (queue.size()!=1){
            ListNode l1 = queue.poll();
            ListNode l2 = queue.poll();
            queue.add(mergeTwoLists(l1, l2));
        }
        return queue.getFirst();
    }

    public ListNode mergeKLists_2(ListNode[] lists) {
        if (lists.length==0) return null;
        int st =0;
        int end = lists.length-1;
        while (end != 0){
            while (st < end) {
                ListNode l1 = lists[st];
                ListNode l2 = lists[end];
                lists[st] = mergeTwoLists(l1, l2);
                st++;
                end--;
            }
            st = 0;
        }
        return lists[0];
    }

    public static void main(String[] args) {
        MergeKLists su = new MergeKLists();
        ListNode l1 = ListNode.createListNodeFromNums(new int[]{1, 4, 5});
        ListNode l2 = ListNode.createListNodeFromNums(new int[]{1, 3, 4});
        ListNode l3 = ListNode.createListNodeFromNums(new int[]{2 , 6});
        ListNode[]lists = new ListNode[]{l1,l2,l3};
        ListNode res = su.mergeKLists_2(lists);
        res.showList();
    }

}
