package demo007_Tree;

/**
 * @author TuanFans
 * @time 2026/7/17 15:26
 * <p><a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">104. 二叉树的最大深度</a></p>
 */
public class Demo_007_05_MaxDepth {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode node){
        if(node==null) return 0;
        int depthL = dfs(node.left);
        int depthR = dfs(node.right);
        return Math.max(depthL,depthR)+1;
    }
}
