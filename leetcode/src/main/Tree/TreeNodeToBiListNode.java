package Tree;

public class TreeNodeToBiListNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode eight = new TreeNode(8);

        root.left = four;
        root.right = seven;

        four.left = two;
        four.right = five;

        two.left = one;
        two.right = three;

        seven.right = nine;
        nine.left = eight;

        TreeNode p = convert(root);
        PrintList(p);

    }


    public static void PrintList(TreeNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
        System.out.println();
    }

    //  method 2
    public static TreeNode convert(TreeNode root) {
        TreeNode lastNode = null;
        lastNode=baseconvert(root, lastNode);
        TreeNode headNode = lastNode;
        while (headNode.left != null)
            headNode = headNode.left;
        return headNode;
    }


    // lastNode is last Node before cur root
    public static TreeNode baseconvert(TreeNode root, TreeNode lastNode) {
        if (root == null)
            return lastNode;
        if (root.left != null)
            lastNode=baseconvert(root.left,lastNode);
        root.left = lastNode;
        if (lastNode != null)   lastNode.right = root;
        lastNode = root;
        if (root.right != null) lastNode=baseconvert(root.right, lastNode);
        return lastNode;
    }
}
