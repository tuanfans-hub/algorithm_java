package demo005_linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TuanFans
 * @time 2026/7/15 15:10
 * <p><a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/">116. 填充每个节点的下一个右侧节点指针</a></p>
 */
public class Demo_007_14_Connect {
    // list的元素为二叉树对应索引层的当前节点
    private static final List<Node> list = new ArrayList<>();
    public Node connect(Node root) {
        dfs(root,0);
        return root;
    }

    /**
     dfs：深度优先搜索
     node: 树节点
     depth: 当前节点在二叉树中的深度
     */
    public void dfs(Node node,int depth){
        if(node==null) return;

        if(depth==list.size()) list.add(node);
        else{
            list.get(depth).next = node;
            list.set(depth,node);
        }

        dfs(node.left,depth+1);
        dfs(node.right,depth+1);
    }
}
