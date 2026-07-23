package demo008_Recusion;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author TuanFans
 * @time 2026/7/23 15:14
 * <p><a href="https://leetcode.cn/problems/basic-calculator-ii/description/">227. 基本计算器 II</a></p>
 */
public class Demo_008_09_BasicCalculator {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] chs = s.toCharArray();
        char sign = '+';
        int num = 0;
        for(int i = 0;i < chs.length;i++){
            char c = chs[i];
            if(Character.isDigit(c)){
                num = 10*num+(c-'0');
            }else if(c==' ') continue;
            else{
                if(sign=='+') stack.push(num);
                else if(sign=='-') stack.push(-num);
                else if(sign=='*') {
                    int prev = stack.pop();
                    stack.push(prev*num);
                }else if(sign=='/'){
                    int prev = stack.pop();
                    stack.push(prev/num);
                }
                sign = c;
                num = 0;
            }
        }
        if(sign=='+') stack.push(num);
        else if(sign=='-') stack.push(-num);
        else if(sign=='*') {
            int prev = stack.pop();
            stack.push(prev*num);
        }else if(sign=='/'){
            int prev = stack.pop();
            stack.push(prev/num);
        }

        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }

        return ans;
    }
}
