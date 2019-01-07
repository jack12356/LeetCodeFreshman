package Tree_BFS;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeBfs {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<TreeNode> prelist = new ArrayList<TreeNode>();

        if (root==null)
            return lists;
        prelist.add(root);
        add(prelist,lists);
        return lists;
    }

    private void  add(ArrayList<TreeNode> prelist,ArrayList<List<Integer>> lists) {
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
        lists.add(intlist);
        if(next_list.size()==0)
            return;
        add(next_list,lists);
    }
}
