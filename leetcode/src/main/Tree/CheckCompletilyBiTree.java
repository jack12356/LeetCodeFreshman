package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletilyBiTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                break;
            } else {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur!=null) return false;
        }
        return true;
    }
}