package demo007_Tree;

/**
 * @author TuanFans
 * @time 2026/7/19 11:56
 * <p><a href="https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/">LCR 194. 二叉树的最近公共祖先</a></p>
 */
public class Demo_007_11_LowestCommonAncestor {
    // 标志位：说明两个节点都已找到
    boolean success = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;

        TreeNode LN = lowestCommonAncestor(root.left,p,q);
        TreeNode RN = lowestCommonAncestor(root.right,p,q);

        // 两个节点都已找到的标志
        // 1. 当前节点为目标节点之一，另一个节点在子树中
        if(root==p || root==q){
            if(LN!=null || RN!=null) success = true;
            return root;
        }
        // 2. 两个节点分别在左子树和右子树中
        if(LN!=null && RN!=null) {
            success = true;
            return root;
        }
        // LN!=null说明：
        // 有目标节点在左子树中
        // 如果success为true，说明两个目标节点都已在左子树中找到，且最近公共祖先为LN，继续返回LN
        // 如果success为false，说明只有一个目标节点在左子树，返回root，继续向上寻找公共祖先
        if(LN!=null) return success?LN:root;
        if(RN!=null) return success?RN:root;

        return null;
    }

    // 简化
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;

        TreeNode LN = lowestCommonAncestor2(root.left,p,q);
        TreeNode RN = lowestCommonAncestor2(root.right,p,q);

        if(LN!=null && RN!=null) return root;

        if(LN==null && RN==null) return null;

        return LN!=null?LN:RN;
    }
}
