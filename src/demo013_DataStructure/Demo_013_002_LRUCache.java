package demo013_DataStructure;

import java.util.HashMap;

/**
 * @author TuanFans
 * @date 2026/7/12
 * <p><a href="https://leetcode.cn/problems/lru-cache/description/">146. LRU 缓存</a></p>
 */
public class Demo_013_002_LRUCache {
    static class DoubleNode{
        int key;
        int value;
        DoubleNode prev;
        DoubleNode next;
        DoubleNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    private HashMap<Integer,DoubleNode> map = new HashMap<>();
    private int size = 0;
    private final int capacity;
    private DoubleNode head;
    private DoubleNode tail;

    public Demo_013_002_LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            // 获取目标节点
            DoubleNode node = map.get(key);
            if(tail==node) return node.value;
            // 获取目标节点的前驱节点
            DoubleNode last = node.prev;

            // 如果前驱节点为head节点，更新head节点
            // 如果不是更新前驱节点的next指针
            if(last==null) {
                head = node.next;
                head.prev = null;
            }
            else {
                node.prev.next = node.next;
            }
            // 更新目标节点的后驱节点的前驱节点
            node.next.prev = last;
            // 将目标节点连接到链表尾部
            tail.next = node;
            node.prev = tail;
            tail = node;
            tail.next = null;

            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            // 如果key存在，则修改该节点的value
            // 获取目标节点
            DoubleNode node = map.get(key);
            // 修改目标节点的value
            node.value = value;
            // 如果目标节点为尾节点，直接退出
            if(tail==node) return;

            // 目标节点不是尾节点的处理
            // 获取目标节点的前驱节点
            DoubleNode last = node.prev;
            if(last==null) {
                // 如果前驱节点为null，即目标节点为head节点的特殊处理
                // 将head节点更新为后驱节点
                head = node.next;
                // 将head节点的前驱节点置为null
                head.prev = null;
            }else {
                // 如果前驱节点不为null，目标节点为中间节点的处理
                // 将前驱节点的next指针连接到后驱节点
                node.prev.next = node.next;
            }
            // 将后驱节点的prev指针连接到前驱节点
            node.next.prev = last;

            // 将目标节点连接到尾节点之后，并更新尾节点
            tail.next = node;
            node.prev = tail;
            tail = node;
            tail.next = null;
        }else{
            // key不存在的处理：直接将节点添加到尾节点，并更新尾节点
            if(size==capacity){
                // 缓存大小达到最大值时，抛弃最久未使用的节点，即删除头节点
                DoubleNode pre = head;
                map.remove(pre.key);
                head = head.next;
                // 将新的头节点的prev指针置为null
                if(head!=null) head.prev = null;
                size--;
            }
            DoubleNode node = new DoubleNode(key, value);
            if(size==0){
                // 缓存为空直接将head和tail指针指向添加的新节点
                head = node;
                tail = node;
            }else{
                // 添加到尾节点，并更新尾节点
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            map.put(key,node);
            size++;
        }
    }
}
