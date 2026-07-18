package demo007_Tree;

/**
 * @author TuanFans
 * @time 2026/7/18 17:24
 * <p><a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">105. 从前序与中序遍历序列构造二叉树</a></p>
 */
public class Demo_007_08_BuildTree {
    // 记录preorder数组遍历的索引
    private int preIndex = 0;
    // 记录inorder数组遍历的索引
    private int inIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,Integer.MAX_VALUE);
    }

    // 构建树
    // stop的含义是val=stop的左节点构建完成
    public TreeNode build(int[] pre,int[] in,int stop){
        if(preIndex>=pre.length) return null;

        // 如果中序数组当前值为stop，说明val=stop的节点的左子树没有节点了（构建完成）
        if(in[inIndex]==stop){
            inIndex++;
            return null;
        }

        TreeNode node = new TreeNode(pre[preIndex++]);
        // 构建左子树
        node.left = build(pre,in,node.val);
        // 构建右子树
        // 为什么这里传入stop作为参数？
        // 根据stop的含义和中序遍历的规则：
        // 构建完当前节点的右子树，也就等价于当前节点的父节点的左子树构建完成
        node.right = build(pre,in,stop);

        return node;
    }
}
