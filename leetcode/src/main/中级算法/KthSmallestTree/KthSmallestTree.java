package KthSmallestTree;

import TreeNode.TreeNode;

import java.util.ArrayList;

public class KthSmallestTree {
    private int count=0;
    private int target;
    public int kthSmallest(TreeNode root, int k) {
        target=k;
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)
            return -1;
        add(list,root);
        return list.get(list.size()-1);
    }

    private void add(ArrayList<Integer> list, TreeNode root) {
        if(root==null)
            return;
        if (++count>=target) return;
        add(list,root.left);
        if (count<target)list.add(root.val);
        add(list,root.right);
    }
}
