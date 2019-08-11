package Tree;

public class IsBanlance {
    private boolean is_balance = true;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        IsBanlance test = new IsBanlance();
        boolean balance = test.isBalance(root);
        System.out.println(balance);
    }

    private boolean isBalance(TreeNode root) {
        maxLen(root);
        return is_balance;
    }

    private int maxLen(TreeNode root) {
        if(root==null) return 0;
        int left_len = maxLen(root.left);
        int rt_len = maxLen(root.right);
        if(Math.abs(left_len-rt_len)>1) is_balance = false;
        return Math.max(left_len, rt_len);
    }
}
