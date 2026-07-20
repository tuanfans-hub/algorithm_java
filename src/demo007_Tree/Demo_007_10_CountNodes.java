package demo007_Tree;

/**
 * @author TuanFans
 * @time 2026/7/18 21:30
 * <p><a href="https://leetcode.cn/problems/count-complete-tree-nodes/">222. 完全二叉树的节点个数（时间复杂度小于O(n)）</a></p>
 */
public class Demo_007_10_CountNodes {
    public int countNodes(TreeNode root) {
        return recursion(root);
    }

    public int recursion(TreeNode node){
        if(node==null) return 0;

        // 当前树的深度
        int cd = getDepth(node);

        // 右子树的深度
        int rd = getDepth(node.right);

        // cc: 待统计子树的节点个数
        int cc = 0;
        // rd+1==cd：意味着左子树为满二叉树
        // 否则，表示右子树为满二叉树
        if(rd+1==cd) cc = recursion(node.right);
        else cc=recursion(node.left);

        // 完整：cc+(2^rd-1)+1
        // 2^rd-1 ： 已知是满二叉树的节点个数=2^(二叉树深度)-1
        // 1：当前节点
        return cc+(1<<rd);
    }

    // 根据完全二叉树的性质，递归左节点，可得二叉树深度
    public int getDepth(TreeNode node){
        int depth = 0;
        while(node!=null){
            node = node.left;
            depth++;
        }
        return depth;
    }
}
