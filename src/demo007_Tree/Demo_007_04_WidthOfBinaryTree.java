package demo007_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TuanFans
 * @time 2026/7/16 20:18
 * <p><a href="https://leetcode.cn/problems/maximum-width-of-binary-tree/">662. 二叉树最大宽度</a></p>
 */
public class Demo_007_04_WidthOfBinaryTree {
    private static final List<Integer> indexs= new ArrayList<>();
    private static final List<Integer> widths = new ArrayList<>();
    // DFS实现
    public int widthOfBinaryTree(TreeNode root) {
        indexs.clear();
        widths.clear();
        dfs(root,0,0);
        int max = 0;
        for(int width:widths){
            max = Math.max(max,width);
        }

        return max;
    }

    public void dfs(TreeNode node,int depth,int index){
        if(node==null) return;

        if(indexs.size()<=depth) {
            indexs.add(index);
            widths.add(1);
        }
        int lastIndex = indexs.get(depth);
        widths.set(depth,index-lastIndex+1);

        dfs(node.left,depth+1,2*index+1);
        dfs(node.right,depth+1,2*index+2);
    }
}
