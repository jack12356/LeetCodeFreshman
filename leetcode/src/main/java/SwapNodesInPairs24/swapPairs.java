package SwapNodesInPairs24;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.
 Your algorithm should use only constant space.
 You may not modify the values in the list, only nodes itself can be changed.
 */
public class swapPairs {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode swapPairsLeet(ListNode head) {
		ListNode start = new ListNode(0);
		ListNode end = new ListNode(0);
		ListNode left;
		ListNode right;
		if ((head == null) || (head.next == null)) {
			return head;
		}
		start.next=end;
		end.next=head;
		while ((end.next != null)&&end.next.next!=null) {
			left = end.next;
			right = end.next.next;
			end.next=right;
			left.next=right.next;
			right.next=left;
			end = left;
		}
		return start.next.next;
	}
	
	public static void main(String[] args) {
		swapPairs s = new swapPairs();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(5);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(15);
		ListNode rst = s.swapPairsLeet(l1);
		while (rst!=null){
			System.out.print(rst.val+"--->");
			rst = rst.next;
		}
	}
	
}
