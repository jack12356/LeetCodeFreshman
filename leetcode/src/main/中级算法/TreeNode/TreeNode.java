package TreeNode;


import ListNode.ListNode;

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

    public static void main(String[] args) {
        String []nums = new String[]{"1","2","3","4","5",null,null};
        TreeNode root = TreeNode.buildTreePreOrder(nums);
        System.out.println(root);

    }

}
