package demo005_linkedList;

/**
 * @author TuanFans
 * @time 2026/7/15 11:15
 * <p><a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/">114. 二叉树展开为链表</a></p>
 */
public class Demo_006_13_Flatten {
    public void flatten(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return;
        preorder(root);
    }

    public TreeNode preorder(TreeNode node){
        if(node.left==null && node.right==null) return node;
        // 记录node节点的右子节点
        TreeNode RNode = node.right;
        // LENode记录左子树的最后一个节点
        // RENode记录右子树的最后一个节点
        TreeNode LENode=null,RENode=null;

        // 递归左子树
        if(node.left!=null) {
            LENode = preorder(node.left);
            // 将左子树连接到node节点右子节点上
            node.right = node.left;
            // 置空
            node.left = null;
        }
        // 递归右子树
        if(RNode!=null) {
            RENode = preorder(RNode);
            // 将右子树连接到左子树的最后一个节点
            if(LENode!=null) LENode.right = RNode;
        }
        // 返回该树的最后一个节点
        return RENode==null?LENode:RENode;
    }
}
