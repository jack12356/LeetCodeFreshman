package ZigZagLevalInOrder;

import TreeNode.TreeNode;

import java.util.*;

public class ZigZagLevelInOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<TreeNode> prelist = new ArrayList<TreeNode>();
        if (root==null)
            return lists;

        boolean reverse = false;
        prelist.add(root);
        add(prelist,lists,reverse);
        return lists;
    }

    private void  add(ArrayList<TreeNode> prelist, ArrayList<List<Integer>> lists, boolean reverse) {
        ArrayList<TreeNode> next_list = new ArrayList<>();
        ArrayList<Integer> intlist = new ArrayList<>();
        for (int i = 0; i < prelist.size(); i++) {
            TreeNode root = prelist.get(i);
            intlist.add(root.val);
            if (root.left!=null)
                next_list.add(root.left);
            if (root.right!=null)
                next_list.add(root.right);
        }
        if (reverse) Collections.reverse(intlist);
        reverse=!reverse;
        lists.add(intlist);
        if(next_list.size()==0) {
            return;
        }
        add(next_list,lists, reverse);
    }

    public static void main(String[] args) {
        ZigZagLevelInOrder solution = new ZigZagLevelInOrder();
        solution.zigzagLevelOrder(null);
    }
}
