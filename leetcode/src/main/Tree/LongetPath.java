package Tree;

public class LongetPath {
    private int maxPath = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        LongetPath test = new LongetPath();
        test.singleLongetPath(root);
        System.out.println(test.maxPath);
    }

    private int singleLongetPath(TreeNode root) {
        if(root==null) return 0;
        int lfDep = singleLongetPath(root.left);
        int rtDep = singleLongetPath(root.right);
        int curPath = lfDep + rtDep + 1;
        if (curPath>maxPath) maxPath = curPath;
        int singlePath = Math.max(lfDep, rtDep) + 1;
        return singlePath;
    }


}
