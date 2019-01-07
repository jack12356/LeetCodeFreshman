package ValidBST;

import TreeNode.TreeNode;

import java.util.ArrayList;


public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        //        System.out.printf("this node is : %d",root.val);
        ArrayList <Integer> list = new ArrayList<>();
        if(root==null)
            return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        add(list,root);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;

    }

    private void add(ArrayList<Integer> list, TreeNode root) {
        if(root==null)
            return;
        add(list,root.left);
        list.add(root.val);
        add(list,root.right);
    }


    public static void main(String[] args) {
        ValidBST solution = new ValidBST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right=new TreeNode(20);

        System.out.printf("result is : %b", solution.isValidBST(root));
    }
}

//class Solution {
//
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//    public boolean valid(TreeNode root, long low, long high) {
//        if (root == null) return true;
//        if (root.val <= low || root.val >= high) return false;
//        return valid(root.left, low, root.val) && valid(root.right, root.val, high);
//    }
//}
