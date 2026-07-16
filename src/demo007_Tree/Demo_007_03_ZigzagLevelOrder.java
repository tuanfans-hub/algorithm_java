package demo007_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TuanFans
 * @time 2026/7/16 18:01
 * <p><a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/">力扣103. 二叉树的锯齿形层序遍历</a></p>
 */
public class Demo_007_03_ZigzagLevelOrder {
    private static final TreeNode[] stack = new TreeNode[20001];
    private static int l;
    private static int r;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root==null) return ans;

        // 清空stack
        l = r = 0;
        stack[r++] = root;
        // 当前遍历顺序是否从左至右
        boolean toR = true;

        while(l<r){
            List<Integer> temp = new ArrayList<>();
            int size = r-l;
            // nextL: 下一轮的l索引
            // nextR: 下一轮的r索引
            int nextL = r,nextR = r;
            for(int i = 0;i < size;i++){
                TreeNode node;
                // 保证后进先出
                node = stack[--r];
                if(toR){
                    // 当前遍历顺序为从左至右
                    // 为保证下一轮的后进先出取值时，遍历顺序为从右至左
                    // 所以现在添加元素从左节点开始
                    if(node.left!=null) stack[nextR++] = node.left;
                    if(node.right!=null) stack[nextR++] = node.right;
                }else{
                    // 当前遍历顺序为从右至左
                    // 为保证下一轮的后进先出取值时，遍历顺序为从左至右
                    // 所以现在添加元素从右节点开始
                    if(node.right!=null) stack[nextR++] = node.right;
                    if(node.left!=null) stack[nextR++] = node.left;
                }
                temp.add(node.val);
            }
            ans.add(temp);
            toR = !toR;
            l = nextL;
            r = nextR;
        }

        return ans;
    }
}
