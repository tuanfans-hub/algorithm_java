package demo007_Tree;

/**
 * @author TuanFans
 * @time 2026/7/17 15:25
 * <p><a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/">111. 二叉树的最小深度</a></p>
 */
public class Demo_007_06_MinDepth {
    private int ans = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        dfs(root,0);
        return root!=null?ans:0;
    }

    public void dfs(TreeNode node,int cnt){
        // ++cnt>=ans：最优化剪枝
        if(node==null || ++cnt>=ans) return;

        // 所以通过剪枝，可知cnt是当前最短
        if(node.left==null && node.right==null) {
            ans = cnt;
            return;
        }

        dfs(node.left,cnt);
        dfs(node.right,cnt);
    }
}
