package demo013_DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author TuanFans
 * @date 2026/7/12
 * <p><a href="https://leetcode.cn/problems/insert-delete-getrandom-o1-duplicates-allowed/">力扣381. O(1) 时间插入、删除和获取随机元素 - 允许重复</a></p>
 */
public class Demo_013_004_RandomizedCollection {
    private final HashMap<Integer,ArrayList<Integer>> VALUE_INDEXS = new HashMap<>();
    private final ArrayList<Integer> list = new ArrayList<>();

    public Demo_013_004_RandomizedCollection() {}

    public boolean insert(int val) {
        // 更新VALUE_INDEXS
        ArrayList<Integer> indexs = VALUE_INDEXS.getOrDefault(val,new ArrayList<Integer>());
        indexs.add(list.size());
        VALUE_INDEXS.put(val,indexs);
        // 更新list
        list.add(val);
        return indexs.size()==1;
    }

    public boolean remove(int val) {
        // list中没有val值，返回false
        if(list.isEmpty() || !VALUE_INDEXS.containsKey(val)) return false;

        // 获取val值的索引
        ArrayList<Integer> valueIndexs = VALUE_INDEXS.get(val);
        int index = valueIndexs.getLast();

        // 如果val不是list中最后一个元素
        if(index!=(list.size()-1)){
            ArrayList<Integer> endIndexs = VALUE_INDEXS.get(list.getLast());
            // 从VALUE_INDEXS中删除list中最后一个元素的索引
            endIndexs.remove(Integer.valueOf(list.size()-1));
            // 将list最后一个元素填补到val值的索引中
            list.set(index,list.getLast());
            endIndexs.add(index);
        }

        // 删除val索引
        valueIndexs.remove(Integer.valueOf(index));
        // 如果删除val索引后，索引列表为空，从VALUE_INDEXS删除键为val的元素
        if(valueIndexs.isEmpty()) VALUE_INDEXS.remove(val);
        // 删除list中最后一个元素
        list.removeLast();

        return true;
    }

    public int getRandom() {
        return list.get((int)(Math.random()*list.size()));
    }
}
