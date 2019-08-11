package Tree;
import java.util.*;

public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        int target = 10;
        List<TreeNode> state = new ArrayList<>();
        List<TreeNode> res = new ArrayList<>();
        findPath(root, target, state, res);
        for (TreeNode p : res) {
            System.out.printf("%d ->", p.val);
        }
    }

    private static void findPath(TreeNode root, int target, List<TreeNode> state, List<TreeNode> res) {
        if(root==null) return;
        if(target==0){
            res.addAll(new ArrayList<>(state));
            return;
        }
        if (root.left != null) {
            List<TreeNode> cur = new ArrayList<>(state);
            cur.add(root.left);
            findPath(root.left,target-root.val,cur,res);
        }
        if (root.right != null) {
            List<TreeNode> cur = new ArrayList<>(state);
            cur.add(root.right);
            findPath(root.right,target-root.val,cur,res);
        }
    }
}
