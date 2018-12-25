package TreeLinkNode;

public class TreeLinkNode {
      int val;
      public TreeLinkNode left, right, next;
      public TreeLinkNode(int x) { val = x; }

      public static void main(String[] args) {
            TreeLinkNode t = null;
            t.next=null;
            System.out.println(t);
      }
}
