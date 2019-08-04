package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Order {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        preorder(root);
        inorder(root);
        backorder(root);
    }

    private static void preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if(p!=null){
                stack.add(p);
                list.add(p.val);
                p = p.left;
            }else {
                p = stack.pop();
                p = p.right;
            }
        }
        System.out.println(list.toString());
    }

    private static void inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty()||p!=null){
            if(p!=null){
                stack.add(p);
                p = p.left;
            }else{
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }
        System.out.println(list.toString());
    }

    private static void backorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(p);
        TreeNode pre = null;
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if(cur.left==pre||cur.right!=pre){
                pre = stack.pop();
                list.add(pre.val);
            }else{
                if(cur.right!=null) stack.add(cur.right);
                if(cur.left!=null) stack.add(cur.left);
            }
        }
        System.out.println(list.toString());
    }
}
