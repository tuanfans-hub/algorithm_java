package demo008_Recusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author TuanFans
 * @time 2026/7/21 18:56
 * <p><a href="https://leetcode.cn/problems/7p8L0Z/">LCR 084. 全排列 II </a></p>
 */
public class Demo_008_05_PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        // 纵向去重
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(ans,temp,nums,used);
        return ans;
    }

    public void dfs(List<List<Integer>> ans,List<Integer> temp,int[] nums,boolean[] used){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }


        for(int i = 0;i < nums.length;i++){
            // used[i]：纵向去重
            // i>0 &&nums[i]==nums[i-1]&&!used[i-1]：横向去重
            if((i>0 &&nums[i]==nums[i-1]&&!used[i-1])|| used[i]) continue;
            used[i] = true;
            temp.add(nums[i]);
            dfs(ans,temp,nums,used);
            temp.removeLast();
            used[i] = false;
        }
    }

    // 方法二
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans,nums,0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans,int[] nums,int index){
        if(index==nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num:nums) temp.add(num);
            ans.add(temp);
        }

        // 横向去重HashSet：与index索引位置的元素交换过的不同值的元素
        HashSet<Integer> set = new HashSet<>();
        for(int j = index;j < nums.length;j++){
            // 如果该元素的值，在set中，说明有一个相同值的元素与index索引位置的元素发生过交换，不再交换（排除重复）
            if(set.contains(nums[j])) continue;
            set.add(nums[j]);
            swap(nums,index,j);
            dfs(ans,nums,index+1);
            swap(nums,index,j);
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
