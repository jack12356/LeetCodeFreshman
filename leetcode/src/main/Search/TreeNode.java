package Search;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static TreeNode buildTreePreOrder(String []nums){
        int i=0;
        List<TreeNode> prelist = new ArrayList<TreeNode>();
        if (nums.length==0) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nums[i++]));
        prelist.add(root);
        while (i<nums.length){
            List<TreeNode> curlist = new ArrayList<TreeNode>();
            for (int j=0;j<prelist.size();j++) {
                TreeNode node = prelist.get(j);
                if (node==null) {
                    i+=2;
                    continue;
                }
                if (i<nums.length){
                    TreeNode left =  nums[i]==null?null:new TreeNode(Integer.parseInt(nums[i]));
                    node.left = left;
                    i++;
                    curlist.add(left);
                }
                if (i<nums.length) {
                    TreeNode right = nums[i]==null?null:new TreeNode(Integer.parseInt(nums[i]));
                    node.right = right;
                    i++;
                    curlist.add(right);
                }
            }
            prelist = curlist;
        }
        return root;
    }

    public List<Integer> serialize(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root) {
        if (root == null) {
            res.add(null);
        } else {
            res.add(root.val);
            dfs(res, root.left);
            dfs(res, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(List<Integer> data) {
        int index[] = {0};
        TreeNode root = build(index, data);
        return root;
    }

    private TreeNode build(int[] index, List<Integer> data) {
        Integer val = data.get(index[0]);
        index[0] = index[0] + 1;
        if (val == null) {
            return null;
        } else {
            TreeNode node = new TreeNode(val);
            node.left = build(index, data);
            node.right = build(index, data);
            return node;
        }
    }



    public static void main(String[] args) {
        String []nums = new String[]{
                "1","2","3","4","5",null,null
        };
        TreeNode root = TreeNode.buildTreePreOrder(nums);
//        System.out.println(root);
        List<Integer> str = new TreeNode(-1).serialize(root);
        System.out.println(str);
        new TreeNode(-1).deserialize(str);
    }

}