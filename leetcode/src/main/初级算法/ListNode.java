package 初级算法;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) { val = x; }

    public void showList(){
        ListNode l1 = this;
        while(l1.next!=null){
            System.out.printf(l1.val +"->");
            l1=l1.next;
        }
        System.out.println(l1.val);
    }

    public static ListNode createListNodeFromNums(int []nums){
        ListNode st = new ListNode(-1);
        ListNode cur = st;
        for (int n :nums) {
            cur.next = new ListNode(n);
            cur=cur.next;
        }
        return st.next;
    }

    public static ListNode TransN(int n) {
        ListNode st = new ListNode(-1);
        if(n==0) return new ListNode(0);
        ListNode now = st;
        while(n!=0){
            now.next=new ListNode(n%10);
            n = n/10;
            now=now.next;
        }
        return st.next;
    }

    public static void main(String[] args) {
        int []nums = new int []{3,5,6,7};
        ListNode l1 = ListNode.createListNodeFromNums(nums);
        l1.showList();
    }
}