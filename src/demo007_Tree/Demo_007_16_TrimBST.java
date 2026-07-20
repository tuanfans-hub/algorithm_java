package demo007_Tree;

/**
 * @author TuanFans
 * @time 2026/7/19 20:27
 * <p><a href="https://leetcode.cn/problems/trim-a-binary-search-tree/">669. 修剪二叉搜索树</a></p>
 */
public class Demo_007_16_TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return null;

        // 修建左子树
        root.left = trimBST(root.left,low,high);
        // 修建右子树
        root.right = trimBST(root.right,low,high);

        // 如果当前节点值小于low，返回右节点，供上层节点连接
        if(root.val<low) return root.right;
        // 如果当前节点值大于high，返回左节点，供上层节点连接
        if(root.val>high) return root.left;

        return root;
    }
}
