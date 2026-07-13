package demo013_DataStructure;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author TuanFans
 * @date 2026/7/12
 * <p><a href="https://leetcode.cn/problems/insert-delete-getrandom-o1/">力扣380. O(1) 时间插入、删除和获取随机元素</a></p>
 */
public class Demo_013_003_RandomizedSet {
    private final HashMap<Integer,Integer> VALUE_INDEX = new HashMap<>();
    private final ArrayList<Integer> list = new ArrayList<>();

    public Demo_013_003_RandomizedSet() {}

    public boolean insert(int val) {
        if(VALUE_INDEX.containsKey(val)) return false;
        VALUE_INDEX.put(val,list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!VALUE_INDEX.containsKey(val)) return false;
        int index = VALUE_INDEX.get(val);
        if(index!=list.size()-1) {
            int end = list.getLast();
            list.set(index,end);
            VALUE_INDEX.put(end,index);
        }

        VALUE_INDEX.remove(val);
        list.removeLast();
        return true;
    }

    public int getRandom() {
        return list.get((int)(Math.random()*list.size()));
    }
}
