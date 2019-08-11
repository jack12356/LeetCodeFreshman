package Tree;

public class MaxLen {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        int depth = maxLen(root);
        System.out.println(depth);
    }

    private static int maxLen(TreeNode root) {
        if(root==null) return 0;
        int left_len = maxLen(root.left);
        int rt_len = maxLen(root.right);
        int depth = Math.max(left_len, rt_len) + 1;
        return depth;
    }
}
