package Tree;

import java.util.*;

public class Order {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        preOrder(root);
        inOrder(root);
        backOrder(root);
        layerOrder(root);
    }


    private static void preOrder(TreeNode root) {
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

    private static void inOrder(TreeNode root) {
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

    private static void backOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(p);
        TreeNode pre = null;
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if((cur.left==null&&cur.right==null)||((pre!=null&&cur.left==pre)||(pre!=null&&cur.right==pre))){
                pre = stack.pop();
                list.add(pre.val);
            }else{
                if(cur.right!=null) stack.add(cur.right);
                if(cur.left!=null) stack.add(cur.left);
            }
        }
        System.out.println(list.toString());
    }


    private static void layerOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null) queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
                list.add(cur.val);
            }
        }
        System.out.println(list.toString());
    }
}
