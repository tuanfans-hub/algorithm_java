package demo013_DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author TuanFans
 * @time 2026/7/13 19:22
 * <p><a href="https://leetcode.cn/problems/all-oone-data-structure/">432. 全 O(1) 的数据结构</a></p>
 */
public class Demo_013_007_AllOne {
    // 为什么DoubleNode中的keys的容器类型为HashSet，而不是ArrayList?
    // 为了删除key的时间复杂度为O(1)
    static class DoubleNode{
        int count;
        HashSet<String> keys;
        DoubleNode prev;
        DoubleNode next;
        public DoubleNode(){}
        public DoubleNode(int count){
            this.count = count;
        }
        public DoubleNode(int count,HashSet<String> keys){
            this.count = count;
            this.keys = keys;
        }
        // 从双向链表中删除节点
        public static void removeNode(DoubleNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // 将目标节点插入到prev节点的后面
        public static void insertNode(DoubleNode prev,DoubleNode node){
            DoubleNode next = prev.next;
            prev.next = node;
            node.next = next;
            next.prev = node;
            node.prev = prev;
        }
    }
    private final HashMap<String,DoubleNode> KEY_NODE = new HashMap<>();
    private final DoubleNode head = new DoubleNode(0);
    private final DoubleNode tail = new DoubleNode(Integer.MAX_VALUE);
    public Demo_013_007_AllOne() {
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if(KEY_NODE.containsKey(key)){
            DoubleNode node = KEY_NODE.get(key);
            node.keys.remove(key);
            if(node.next.count==node.count+1){
                node.next.keys.add(key);
            }else{
                HashSet<String> keys = new HashSet<>();
                keys.add(key);
                DoubleNode temp = new DoubleNode(node.count+1,keys);
                DoubleNode.insertNode(node,temp);
            }
            KEY_NODE.put(key,node.next);
            if(node.keys.isEmpty()) DoubleNode.removeNode(node);
        }else{
            if(head.next.count==1){
                head.next.keys.add(key);
            }else{
                HashSet<String> keys = new HashSet<>();
                keys.add(key);
                DoubleNode temp = new DoubleNode(1,keys);
                DoubleNode.insertNode(head,temp);
            }
            KEY_NODE.put(key,head.next);
        }
    }

    public void dec(String key) {
        DoubleNode node = KEY_NODE.get(key);
        node.keys.remove(key);
        if(node.prev.count==node.count-1){
            if(node.prev.count==0) KEY_NODE.remove(key);
            else node.prev.keys.add(key);
        }else{
            HashSet<String> keys = new HashSet<>();
            keys.add(key);
            DoubleNode temp = new DoubleNode(node.count-1,keys);
            DoubleNode.insertNode(node.prev,temp);
        }
        // 防止向head的keys中添加key
        if(node.prev!=head) KEY_NODE.put(key,node.prev);
        if(node.keys.isEmpty()) DoubleNode.removeNode(node);
    }

    public String getMaxKey() {
        // 使用iterator().next()获取任意值
        return tail.prev.keys==null?"":tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        // 使用iterator().next()获取任意值
        return head.next.keys==null?"":head.next.keys.iterator().next();
    }
}
