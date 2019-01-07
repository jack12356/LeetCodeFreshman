package ReverseNodesInKGroup25;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 k is a positive integer and is less than or equal to the length of the linked list.
 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 You may not alter the values in the nodes, only nodes itself may be changed.
 Only constant memory is allowed.
 For example,
 Given this linked list: 1->2->3->4->5
 For k = 2, you should return: 2->1->4->3->5
 For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseKGroup {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if(k<=1) return head;
		ListNode start = new ListNode(0);
		ListNode end = new ListNode(0);
		start.next = end;
		end.next = head;
		ListNode temp = end;
		int tempcNum = 0;
		while (temp.next!=null){
			tempcNum++;
			temp = temp.next;
			if (tempcNum == k) {
				end = reverse(end,k);   //this time temp changed to the first place
				temp = end;
				tempcNum=0;
			}
		}
		return start.next.next;
	}
	
	private ListNode reverse(ListNode prehead,int k) {
		if (k==1) return prehead.next;
		ListNode head = prehead.next;
		ListNode last = prehead;
		for (int i = 0; i < k-1; i++) {
			last = last.next;
		}
		ListNode prelast =last;
		last = last.next;
		//reverse last to first
		prelast.next=last.next;
		prehead.next = last;
		last.next = head;
		//use return function
		return reverse(last, k - 1);
	}
	
	public ListNode reverseKGroupByLeetCode(ListNode head, int k) {
		if(head == null || head.next == null) return head;
		if( k <=1) return head;
		ListNode cur = head;
		for(int i = 0 ; i < k ; i++){
			if(cur == null) return head;
			cur = cur.next;
		}
		
		ListNode pre = null;
		cur = head;
		ListNode next = null;
		for(int i = 0 ; i < k ; i++){
			next =cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		head.next = reverseKGroup(next, k);
		return pre;
	}
	
	public static void main(String[] args) {
		ReverseKGroup test = new ReverseKGroup();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		ListNode rst = test.reverseKGroup(l1,2);
		while (rst!=null){
			System.out.print(rst.val+"--->");
			rst = rst.next;
		}
	}
}
