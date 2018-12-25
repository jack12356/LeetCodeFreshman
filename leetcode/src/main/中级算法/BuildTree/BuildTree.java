package BuildTree;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> p = Arrays.stream( preorder ).boxed().collect(Collectors.toList());
        List<Integer> i = Arrays.stream( inorder ).boxed().collect(Collectors.toList());
        return buildTreeArray(p,i);
    }
    public TreeNode buildTreeArray(List<Integer> preorder,List<Integer>inorder){
        if(preorder.size()==0) return null;
        if(preorder.size()==1) return new TreeNode(preorder.get(0));
        int rt = preorder.get(0);
        int rt_index = inorder.indexOf(rt);
        TreeNode root = new TreeNode(rt);
        root.left = buildTreeArray(preorder.subList(1,rt_index+1),inorder.subList(0,rt_index) );
        root.right = buildTreeArray(preorder.subList(rt_index+1,preorder.size()),inorder.subList(rt_index+1,inorder.size()) );
        return root;
    }

    public static void main(String[] args) {
        BuildTree solution = new BuildTree();
        int [] preorder = new int[]{3,9,20,15,7};
        int [] inorder = new int[]{9,3,15,20,7,};
        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println(root);
    }
}
