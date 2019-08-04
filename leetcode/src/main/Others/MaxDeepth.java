public class MaxDeepth {
    public static void main(String[] args) {
        MaxDeepth test = new MaxDeepth();
        TreeNode root = new TreeNode(0);
        int res = test.max_deep(root);
        System.out.println(res);
    }

    private int max_deep(TreeNode root) {
        if(root==null) return 0;
        int lf_deep = max_deep(root.left);
        int rt_deep= max_deep(root.right);
        int deep = Math.max(lf_deep, rt_deep)+1;
        return deep;
    }
}