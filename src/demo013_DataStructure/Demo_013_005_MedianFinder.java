package demo013_DataStructure;

import java.util.PriorityQueue;

/**
 * @author TuanFans
 * @time 2026/7/13 11:49
 * <p><a href="https://leetcode.cn/problems/find-median-from-data-stream/">力扣295. 数据流的中位数</a></p>
 */
public class Demo_013_005_MedianFinder {
    // 小根堆：存放大的数
    private final PriorityQueue<Integer> biggers = new PriorityQueue<>((a,b)->a-b);
    // 大根堆：存放较小的数
    private final PriorityQueue<Integer> smallers = new PriorityQueue<>((a,b)->b-a);
    public Demo_013_005_MedianFinder() {}

    public void addNum(int num) {
        // 第一个元素加到smaller大根堆中，避免后去调用smallers.peek()时，smallers为null
        if(smallers.isEmpty() && biggers.isEmpty()){
            smallers.offer(num);
            return;
        }
        if(smallers.peek()>=num){
            // 较小的数的最大值大于num，则将num加到smaller大根堆中
            smallers.offer(num);
            // 如果添加元素之后，smaller与biggers的元素个数差大于1
            // 调整元素个数差：将smallers的堆顶元素弹出，加到biggers中
            if(smallers.size()>biggers.size()+1){
                biggers.offer(smallers.poll());
            }
        }else{
            biggers.offer(num);
            if(smallers.size()+1<biggers.size()){
                smallers.offer(biggers.poll());
            }
        }
    }

    public double findMedian() {
        // 没有任何一个元素时，返回0
        if(smallers.isEmpty()&&biggers.isEmpty()) return 0;
        // 获取中位数
        if(smallers.size()==biggers.size()) return (smallers.peek()+biggers.peek())/2.0;
        else return smallers.size()<biggers.size()?biggers.peek():smallers.peek();
    }
}
