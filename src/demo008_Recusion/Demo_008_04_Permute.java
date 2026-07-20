package demo008_Recusion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TuanFans
 * @time 2026/7/20 20:55
 * <p><a href="https://leetcode.cn/problems/VvJkup/">LCR 083. 全排列</a></p>
 */
public class Demo_008_04_Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(ans,temp,nums,0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans,List<Integer> temp,int[] nums,int index){
        // 递归出口
        if(temp.size()==nums.length){
            List<Integer> copy = new ArrayList<>(temp);
            ans.add(copy);
            return;
        }

        for(int i = 0;i < nums.length;i++){
            // 全排列
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            dfs(ans,temp,nums,i);
            // 回溯：恢复现场
            temp.removeLast();
        }
    }

    // 方法二：更优的写法
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans,nums,0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans,int[] nums,int index){
        // 递归出口
        if(index==nums.length){
            List<Integer> copy = new ArrayList<>();
            for (int num : nums) copy.add(num);
            ans.add(copy);
            return;
        }

        for(int j = index;j < nums.length;j++){
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
