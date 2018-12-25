package ConnectTree;

import TreeLinkNode.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectTree {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        int num=1;
        int next=0;
        TreeLinkNode lastRight = root;
        boolean is_first=true;
        while (!queue.isEmpty()){
            TreeLinkNode cur = queue.poll();
            num--;

            TreeLinkNode left = cur.left;
            TreeLinkNode right = cur.right;
            next+=2;

            if (left==null||right==null) continue;

            queue.add(left);
            queue.add(right);

            if (!is_first)lastRight.next=left;
            left.next=right;
            lastRight = right;

            if (num==0){
                num=next;
                next=0;
                is_first=true;
            } else {
                is_first=false;
            }

        }
    }
}
