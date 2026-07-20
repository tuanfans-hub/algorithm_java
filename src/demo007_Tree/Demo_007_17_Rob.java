package demo007_Tree;

/**
 * @author TuanFans
 * @time 2026/7/19 21:30
 * <p><a href="https://leetcode.cn/problems/house-robber-iii/">337. 打家劫舍 III</a></p>
 */
public class Demo_007_17_Rob {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        // 根节点打劫或不打劫，取最大值即可
        return Math.max(result[0], result[1]);
    }

    // 返回打劫与不打劫两种情况的收益状态
    // 索引0为不打劫的收益状态
    // 索引1为打劫的收益状态
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        // 递归获取左右子树的状态
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // 1. 如果当前节点【不打劫】：
        // 左右子节点可以打劫也可以不打劫，分别取左右子树的最大值相加
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        // 2. 如果当前节点【打劫】：
        // 左右子节点【不能打劫】，只能取左右子树不打劫的值 (left[0] 和 right[0])
        int rob = node.val + left[0] + right[0];

        return new int[]{notRob, rob};
    }
}
