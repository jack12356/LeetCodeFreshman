package SortedArrayToBST;

import TreeNode.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = generateTree(nums,0,nums.length);
        return root;
    }

    private TreeNode generateTree(int[] nums,int st,int end) {
        int len = end-st;
        if(len==0)
            return null;
        int mid = st + len/2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = generateTree(nums,st,mid);
        TreeNode right = generateTree(nums,mid+1,end);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        SortedArrayToBST solution = new SortedArrayToBST();
        solution.sortedArrayToBST(nums);
    }
}
