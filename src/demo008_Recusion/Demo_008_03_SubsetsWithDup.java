package demo008_Recusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author TuanFans
 * @time 2026/7/20 19:44
 * <p><a href="https://leetcode.cn/problems/subsets-ii/">90. 子集 II</a></p>
 */
public class Demo_008_03_SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        // 排序将所有值相同的元素，放到一起
        Arrays.sort(nums);
        dfs(ans,temp,nums,0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans,List<Integer> temp,int[] nums,int index){
        // 递归出口
        if(index==nums.length){
            List<Integer> copy = new ArrayList<>(temp);
            ans.add(copy);
            return;
        }

        // 获取值相同的元素个数
        int count = count(nums,index);
        // 如果当前值相同的元素个数有n个
        // 那么分别取0，1，2，...，n个当前元素进行后续组合
        for(int i = 0;i <= count;i++){
            for(int j = 0;j<i;j++) temp.add(nums[index]);
            // 跳转到下一个值不同的元素索引，进行后续组合
            dfs(ans,temp,nums,index+count);
            // 恢复现场
            for(int j = 0;j<i;j++) temp.removeLast();
        }
    }

    // 统计与当前索引元素值相同的元素个数
    public int count(int[] nums,int index){
        int count = 1,i=index+1;
        while(i<nums.length && nums[i]==nums[index]) {
            count++;
            i++;
        }
        return count;
    }

    // 方法二：利用validIndex：temp数组待添加的位置索引，实现temp数组元素可覆盖，避免了恢复现场的开销
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] temp = new int[nums.length];
        // 排序将所有值相同的元素，放到一起
        Arrays.sort(nums);
        dfs(ans,nums,0,temp,0);
        return ans;
    }

    // curIndex：nums当前待遍历的位置索引
    // validIndex：temp数组待添加的位置索引
    public void dfs(List<List<Integer>> ans,int[] nums,int curIndex,int[] temp,int validIndex){
        // 递归出口
        if(curIndex==nums.length){
            List<Integer> copy = new ArrayList<>();
            for(int i = 0;i < validIndex;i++) copy.add(temp[i]);
            ans.add(copy);
            return;
        }

        // 如果当前值相同的元素个数有n个
        // 那么分别取0，1，2，...，n个当前元素进行后续组合

        // 获取下一个值不同的元素索引
        int j = curIndex+1;
        while(j<nums.length && nums[curIndex]==nums[j]) j++;

        // 取0个与当前元素值相等的数
        dfs(ans,nums,j,temp,validIndex);

        // 分别取1，2，...，n个与当前元素值相等的数
        for(;curIndex < j;curIndex++){
            temp[validIndex++] = nums[curIndex];
            dfs(ans,nums,j,temp,validIndex);
        }
    }
}
