package demo007_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TuanFans
 * @time 2026/7/19 15:13
 */
public class Demo_007_13_PathSum {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> temp = new ArrayList<>();
        dfs(temp,root,targetSum);
        return list;
    }

    public void dfs(List<Integer> ans,TreeNode node,int rest){
        if(node==null) return;

        ans.add(node.val);

        // 从根节点到叶子节点的路径：所以需要判断当前节点的左、右节点
        if(rest==node.val && node.left==null && node.right==null) {
            List<Integer> copy = new ArrayList<>();
            for(int num:ans){
                copy.add(num);
            }
            list.add(copy);
        }


        dfs(ans,node.left,rest-node.val);
        dfs(ans,node.right,rest-node.val);
        // 回溯
        ans.removeLast();
    }
}
