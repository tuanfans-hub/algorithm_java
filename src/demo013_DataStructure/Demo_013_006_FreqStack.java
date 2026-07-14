package demo013_DataStructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author TuanFans
 * @time 2026/7/13 18:08
 * <p><a href="https://leetcode.cn/problems/maximum-frequency-stack/">力扣895. 最大频率栈</a></p>
 */
public class Demo_013_006_FreqStack {
    private final HashMap<Integer,Integer> VALUE_RATE = new HashMap<>();
    private final HashMap<Integer, Deque<Integer>> RATE_VALUES = new HashMap<>();
    // 记录当前最大频率
    private int maxRate = 0;
    public Demo_013_006_FreqStack() {

    }

    public void push(int val) {
        // 更新VALUE_RATE
        int rate = VALUE_RATE.getOrDefault(val,0)+1;
        VALUE_RATE.put(val,rate);

        // 更新RATE_VALUES
        Deque<Integer> values = RATE_VALUES.getOrDefault(rate,new ArrayDeque<>());
        values.push(val);
        RATE_VALUES.put(rate,values);

        // 更新maxRate
        maxRate = Math.max(maxRate, rate);
    }

    public int pop() {
        // 出栈
        Deque<Integer> values = RATE_VALUES.get(maxRate);
        int value = values.pop();
        // 更新VALUE_RATE
        VALUE_RATE.put(value,maxRate-1);
        if(values.isEmpty()) maxRate--;
        return value;
    }
}
