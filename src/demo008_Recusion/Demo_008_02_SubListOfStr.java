package demo008_Recusion;

import java.util.TreeSet;

/**
 * @author TuanFans
 * @time 2026/7/20 16:32
 * <p><a href="https://www.nowcoder.com/practice/92e6247998294f2c933906fdedbc6e6a">牛客：字符串的全部子序列</a></p>
 */
public class Demo_008_02_SubListOfStr {
    public String[] generatePermutation (String s) {
        // TreeSet：在去重的同时，自动排序
        TreeSet<String> set = new TreeSet<>();
        dfs(s.toCharArray(),0,new StringBuilder(),set);
        String[] ans = new String[set.size()];
        int i = 0;
        for(String str:set){
            ans[i++] = str;
        }
        return ans;
    }

    public void dfs(char[] chs,int index,StringBuilder sb,TreeSet<String> set){
        if(index==chs.length){
            set.add(sb.toString());
            return;
        }
        sb.append(chs[index]);
        dfs(chs,index+1,sb,set);
        sb.deleteCharAt(sb.length()-1);
        dfs(chs,index+1,sb,set);
    }

    // 不是StringBuilder,使用char[] temp
    public String[] generatePermutation2 (String s) {
        // write code here
        TreeSet<String> set = new TreeSet<>();
        char[] chs = s.toCharArray();
        char[] temp = new char[chs.length];
        dfs(chs,0,temp,0,set);
        String[] ans = new String[set.size()];
        int i = 0;
        for(String str:set){
            ans[i++] = str;
        }
        return ans;
    }

    public void dfs(char[] chs,int curIndex,char[] temp,int validIndex,TreeSet<String> set){
        if(curIndex==chs.length){
            set.add(String.valueOf(temp,0,validIndex));
            return;
        }
        temp[validIndex] = chs[curIndex];
        dfs(chs,curIndex+1,temp,validIndex+1,set);
        dfs(chs,curIndex+1,temp,validIndex,set);
    }
}
