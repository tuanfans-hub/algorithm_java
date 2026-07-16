package demo007_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TuanFans
 * @time 2026/7/16 11:57
 * <p><a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/">102. 二叉树的层序遍历</a></p>
 */
public class Demo_007_02_LevelOrder {
    static List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        list.clear();
        dfs(root,0);
        return list;
    }

    public void dfs(TreeNode node,int depth){
        if(node==null) return;

        if(list.size()<=depth) {
            ArrayList<Integer> temp = new ArrayList<>();
            list.add(temp);
        }
        List<Integer> temp = list.get(depth);
        temp.add(node.val);

        dfs(node.left,depth+1);
        dfs(node.right,depth+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Demo_007_02_LevelOrder demo = new Demo_007_02_LevelOrder();
        List<List<Integer>> result = demo.levelOrder(root);
        IO.println(result);// [[3], [9, 20], [15, 7]]
    }
}
