package Sort;

public class BuildTreeFromListNode {
    public TreeNode buildTree(ListNode pre, ListNode in){
        if(pre==null||in==null) return null;
        ListNode mid = in;
        ListNode prert = pre;
        while (mid.val != pre.val) {
            mid = mid.next;
            prert = prert.next;
        }
        TreeNode root = new TreeNode(pre.val);
        root.left = buildTree(pre.next,in);
        root.right = buildTree(prert.next, mid.next);
        return root;
    }
}
