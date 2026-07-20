package demo007_Tree;

/**
 * @author TuanFans
 * @time 2026/7/19 17:00
 * <p><a href="https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/">LCR 176. 判断是否为平衡二叉树</a></p>
 */
public class Demo_007_14_IsBalanced {
    boolean balance = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return balance;
    }

    public int dfs(TreeNode node){
        if(node==null || !balance) return 0;

        int LD = dfs(node.left);
        int RD = dfs(node.right);

        if(Math.abs(LD-RD)>1) balance = false;

        return Math.max(LD,RD)+1;
    }
}
