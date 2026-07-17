package demo007_Tree;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @author TuanFans
 * @time 2026/7/17 15:56
 * <p><a href="https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof/">LCR 156. 序列化与反序列化二叉树</a></p>
 */
public class Demo_007_07_Codec {

    // 序列化：通过先序遍历二叉树，将二叉树转换为字符串
    public String serialize(TreeNode root) {
        StringJoiner sj = new StringJoiner(",");
        dfs(sj,root);
        return sj.toString();
    }

    public void dfs(StringJoiner sj,TreeNode node){
        if(node==null) {
            sj.add("#");
            return;
        }
        sj.add(String.valueOf(node.val));
        dfs(sj,node.left);
        dfs(sj,node.right);
    }

    // 反序列化：通过先序遍历的字符串，还原二叉树
    static int index = 0;
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        System.out.println(Arrays.toString(values));
        index = values.length-1;
        return dedfs(values);
    }

    public TreeNode dedfs(String[] values){
        String str = values[index--];
        if(str.equals("#")) return null;

        TreeNode pN = new TreeNode(Integer.parseInt(str));
        pN.right = dedfs(values);
        pN.left = dedfs(values);
        return pN;
    }
}
