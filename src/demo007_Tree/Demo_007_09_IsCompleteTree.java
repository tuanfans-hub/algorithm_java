package demo007_Tree;

/**
 * @author TuanFans
 * @time 2026/7/18 19:03
 * <p><a href="https://leetcode.cn/problems/check-completeness-of-a-binary-tree/">958. 二叉树的完全性检验</a></p>
 */
public class Demo_007_09_IsCompleteTree {
    private static final TreeNode[] queue = new TreeNode[101];
    private static int l = 0;
    private static int r = 0;
    public boolean isCompleteTree(TreeNode root) {
        if(root.left==null && root.right==null) return true;
        l = r = 0;
        queue[r++] = root;

        // 是否遇到双子节点不全的节点
        boolean leaf = false;
        while(l<r){
            TreeNode node = queue[l++];

            // 两种情况返回false:
            // 1.节点的左子节点为null，右子节点不为null
            // 2.已经遇到了双子节点不全的节点，而当前节点又存在子节点
            if((node.left==null && node.right!=null) || (leaf && (node.left!=null || node.right!=null))) return false;
            // 可简化为以下代码：
            // if(node.left == null && node.right != null || leaf && node.left != null) return false;

            if(node.left!=null) queue[r++] = node.left;
            if(node.right!=null) queue[r++] = node.right;

            if(node.left==null || node.right==null) leaf = true;
        }

        return true;
    }
}
