package DeleteNodeList;


import ListNode.ListNode;

public class DeleteNodeList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
