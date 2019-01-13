public class LowestCommonAncestor {
    TreeNode p,q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q= q;
        return dfs(root);
    }
    public TreeNode dfs(TreeNode root){
        if(root==null) return null;
        TreeNode left_res = dfs(root.left);
        TreeNode right_res = dfs(root.right);
        //左右有解或者根节点为解
        if ((root.val==p.val||root.val==q.val)||(left_res!=null&&right_res!=null)) return root;
        //左边有解
        if (left_res != null) return left_res;
        //右边有解
        if (right_res != null) return right_res;
        //无解
        return null;
    }
}
