package Graph;

import static java.lang.Math.max;

public class BinaryDirect {
    int res = 0;
    int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root, res);
        return res;
    }
    int maxDepth(TreeNode node, int res) {
        if(node==null) {
            return 0;
        }
        int left = maxDepth(node.left, res);
        int right = maxDepth(node.right, res);
        res = max(res, left + right);
        return max(left, right) + 1;
    }

}
