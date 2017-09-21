package MergekSortedLists23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MergeKLists {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode mergeKLists(ListNode[] lists) {
//		List<ListNode> nodes = Arrays.asList(lists);
		List<ListNode> nodes = new ArrayList<>();
		for (ListNode node:lists) {
			nodes.add(node);
		}
		ListNode start = new ListNode(0);
		ListNode end = new ListNode(0);
		start.next = end;
		while (nodes.size()!=0) {
			if (nodes.get(0)==null) {nodes.remove(0);continue;}
			ListNode tempNode = nodes.get(0);
			int temp=0;
			for (int i = 0; i < nodes.size(); i++) {
				if ((nodes.get(i) == null)) {
					nodes.remove(i);
					i--;
					continue;
				}
				if (nodes.get(i).val<tempNode.val){
					temp = i;
					tempNode=nodes.get(i);
//					nodes.set(i, nodes.get(i).next);
				}
			}
			end.next = tempNode;
			if (nodes.get(temp).next!=null){
				nodes.set(temp, nodes.get(temp).next);
			} else {
				nodes.remove(temp);
			}
			end = end.next;
		}
		return start.next.next;
	}
	
	ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
	
	ListNode mergeByLists(List<ListNode> nodes){
		if (nodes.size()==1)return nodes.get(0);
		if (nodes.size()==2) return mergeTwoLists(nodes.get(0),nodes.get(1));
		ListNode nodeOflists1 = mergeByLists(nodes.subList(0, nodes.size() / 2));
		ListNode nodeOflists2 = mergeByLists(nodes.subList(nodes.size() / 2,nodes.size()));
		return mergeTwoLists(nodeOflists1, nodeOflists2);
	}
	
	public ListNode mergeKListsBy2(ListNode[] lists) {
		List<ListNode> nodes = new ArrayList<>();
		Collections.addAll(nodes, lists);
		if (nodes.size()==0)return null;
		return mergeByLists(nodes);
	}
	
	
	
	public static void main(String[] args) {
		MergeKLists test = new MergeKLists();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(5);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(15);
		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(8);
		l2.next.next.next = new ListNode(13);
		l2.next.next.next.next = new ListNode(16);
		ListNode []lists = {null,null,null,null,null};
//		ListNode rst = test.mergeKLists(lists);
		ListNode rst = test.mergeKListsBy2(lists);
		while (rst!=null){
			System.out.print(rst.val+"--->");
			rst = rst.next;
		}
	}
}
