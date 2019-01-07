package ListNode;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public void showList(){
        ListNode l1 = this;
        while(l1.next!=null){
            System.out.printf(String.valueOf(l1.val)+"->");
            l1=l1.next;
        }
        System.out.println(l1.val);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-1);
        ListNode l2=l1;
        for (int i = 0; i < 5; i++) {
            l1.next=new ListNode(i);
            l1=l1.next;
        }
        l2.showList();
    }
}
