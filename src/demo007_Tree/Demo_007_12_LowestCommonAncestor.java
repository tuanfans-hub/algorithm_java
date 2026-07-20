package demo007_Tree;

/**
 * @author TuanFans
 * @time 2026/7/19 14:26
 * <p><a href="https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/">LCR 193. 二叉搜索树的最近公共祖先</a></p>
 */
public class Demo_007_12_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 直接返回当前节点：
        // 1. 任意一个目标节点的值等于当前节点的值
        // 2. 目标节点分布在当前节点的左右两侧
        if(root.val==p.val || root.val==q.val || (p.val<root.val && q.val>root.val) || (p.val>root.val && q.val<root.val)) return root;

        // 如果都小于root.val，表示目标节点都在当前节点左子树中
        if(p.val<root.val) return lowestCommonAncestor(root.left,p,q);

        // 否则就在右子树中
        return lowestCommonAncestor(root.right,p,q);
    }
}
