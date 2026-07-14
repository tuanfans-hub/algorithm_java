package demo005_linkedList;

/**
 * @author TuanFans
 * @time 2026/7/14 17:53
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.val = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int value) {
        this.val = value;
        this.left = null;
        this.right = null;
    }
}
