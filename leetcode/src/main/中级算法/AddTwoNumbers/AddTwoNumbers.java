package AddTwoNumbers;


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n = 0;
        int div = 0;
        int temp;
        while (l1!=null||l2!=null){
            if (l1==null) temp=l2.val;
            else if (l2==null) temp=l1.val;
            else temp = l1.val+l2.val;
            n = (int) (n + temp*Math.pow(10,div));
            l1 = l1==null?l1:l1.next;
            l2 = l2==null?l2:l2.next;
            div++;
        }
        return ListNode.TransN(n);
    }

    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        int over = 0;
        int temp;
        ListNode st = new ListNode(-1);
        ListNode cur = st;
        while (l1!=null||l2!=null){
            if (l1==null) temp=l2.val+over;
            else if (l2==null) temp=l1.val+over;
            else temp = l1.val+l2.val+over;
            over = temp/10;
            cur.next=new ListNode(temp%10);
            l1 = l1==null?l1:l1.next;
            l2 = l2==null?l2:l2.next;
            cur = cur.next;
        }
        if(over == 1) cur.next = new ListNode(1);
        return st.next;
    }

    public static void main(String[] args) {
        int []nums1 = new int[]{};
        int []nums2 = new int[]{9};
        ListNode l1 = ListNode.createListNodeFromNums(nums1);
        ListNode l2 = ListNode.createListNodeFromNums(nums2);
        AddTwoNumbers solution = new AddTwoNumbers();
        solution.addTwoNumbers(l1,l2).showList();
    }
}
