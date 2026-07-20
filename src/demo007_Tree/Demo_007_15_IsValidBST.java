package demo007_Tree;

/**
 * @author TuanFans
 * @time 2026/7/19 17:42
 * <p><a href="https://leetcode.cn/problems/validate-binary-search-tree/submissions/">98. 验证二叉搜索树</a></p>
 */
public class Demo_007_15_IsValidBST {
    // 先序遍历实现
    boolean bst = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
        return bst;
    }

    public void dfs(TreeNode node,long min,long max){
        if(node==null || !bst) return;

        // 当前节点的值
        // 最大不能大于或等于max
        // 最小不能小于或等于min
        if(node.val>=max || node.val<=min)  bst = false;

        dfs(node.left,min,node.val);
        dfs(node.right,node.val,max);
    }

    // 中序遍历，充分利用了二叉搜索树的性质
    long pre = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if(root==null) return true;

        if(!isValidBST2(root.left)) return false;

        if(root.val<=pre) return false;
        pre = root.val;
        return isValidBST2(root.right);
    }

    // 后序遍历实现
    public boolean isValidBST3(TreeNode root) {
        return dfs(root)[0] != Long.MIN_VALUE;
    }

    // 返回子树中的最小值和最大值组成的数组：{min,max}
    public long[] dfs(TreeNode node){
        // 当前节点为null时，最小值置为Long.MAX_VALUE，最大值置为Long.MIN_VALUE
        // 为了不影响返回上层方法时，Math.min()和Math.max()不受影响
        if(node==null) return new long[]{Long.MAX_VALUE,Long.MIN_VALUE};

        // 找左子树的最小值和最大值
        long[] lnx = dfs(node.left);
        // 找右子树的最小值和最大值
        long[] rnx = dfs(node.right);

        long x = node.val;

        // 如果不满足二叉搜索树的规则，向上层返回数组{Long.MIN_VALUE,Long.MAX_VALUE}
        if(x<=lnx[1] || x>=rnx[0]) return new long[]{Long.MIN_VALUE,Long.MAX_VALUE};

        return new long[]{Math.min(lnx[0],x),Math.max(rnx[1],x)};
    }

    // 后序遍历实现
    long min,max;
    public boolean isValidBST4(TreeNode root) {
        if(root==null){
            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            return true;
        }

        boolean LBST = isValidBST4(root.left);
        long LMin = min;
        long LMax = max;
        boolean RBST = isValidBST4(root.right);
        long RMin = min;
        long RMax = max;
        min = Math.min(Math.min(LMin,RMin),root.val);
        max = Math.max(Math.max(LMax,RMax),root.val);

        return LBST && RBST && (LMax<root.val) && (RMin>root.val);
    }
}
