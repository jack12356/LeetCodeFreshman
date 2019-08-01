
public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        if (root==null) return Integer.MIN_VALUE;
        int leftLength = len(root.left);
//        leftLength = leftLength < 0 ? 0 : leftLength;
        int rightLength = len(root.right);
//        rightLength = rightLength < 0 ? 0 : rightLength;

        int root_len = leftLength+rightLength+root.val;
        int left_len = maxPathSum(root.left);
        int right_len = maxPathSum(root.right);

        return Math.max(Math.max(root_len, left_len), right_len);
    }

    private int len(TreeNode root) {
        if (root==null) return 0;
        int rootLen = Math.max(len(root.left), len(root.right)) + root.val;
        return rootLen < 0 ? 0 : rootLen;
    }
}
