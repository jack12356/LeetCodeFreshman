import java.util.Stack;

public class PreOrder {
    public int preorder(TreeNode root){
        int res = -1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if(p!=null){
                stack.add(p);
                p = p.left;
            }else {
                p = stack.pop();
                p = p.right;
            }
        }
        return 0;
    }
}
