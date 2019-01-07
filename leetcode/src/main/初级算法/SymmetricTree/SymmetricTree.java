package SymmetricTree;

import TreeNode.TreeNode;

import java.util.ArrayList;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isequal(root.left,root.right);

    }

    private boolean isequal(TreeNode left, TreeNode right) {
        if(left==null||right==null)
           return left==right;
        return (left.val==right.val)&&isequal(left.left,right.right)&&isequal(right.left,left.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        SymmetricTree solution = new SymmetricTree();
        System.out.printf("the result is : %b", solution.isSymmetric(root));

    }
}
