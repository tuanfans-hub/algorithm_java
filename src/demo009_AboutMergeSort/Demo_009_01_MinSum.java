package demo009_AboutMergeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * @author TuanFans
 * @time 2026年5月7日 17:33:54
 * <p>
 * 计算数组的小和
 * https://www.nowcoder.com/practice/edfe05a1d45c4ea89101d936cac32469
 * 
 * 数组小和的定义如下： ∑𝑖=1𝑛𝑓𝑖 (其中 𝑓𝑖  的定义是第 i 个数的左侧小于等于 𝑠𝑖  的个数)
 * 例如，数组 s = [1, 3, 5, 2, 4, 6] ，
 * 在 s[0] 的左边小于或等于 s[0] 的数的和为 0 ； 
 * 在 s[1] 的左边小于或等于 s[1] 的数的和为 1 ；
 * 在 s[2] 的左边小于或等于 s[2] 的数的和为 1+3=4 ；
 * 在 s[3] 的左边小于或等于 s[3] 的数的和为 1 ； 
 * 在 s[4] 的左边小于或等于 s[4] 的数的和为 1+3+2=6 ；
 * 在 s[5] 的左边小于或等于 s[5] 的数的和为 1+3+5+2+4=15 。
 * 所以 s 的小和为 0+1+4+1+6+15=27 
 * 给定一个数组 s ，实现函数返回 s 的小和 
 * 数据范围：0<n≤10^5  ， |si|≤100 
 * </p>
 */
public class Demo_009_01_MinSum {
	public static int MAXN = 100001;
	public static int[] array = new int[MAXN];
	public static int[] temp = new int[MAXN];
	public static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		in.nextToken();
		n = (int)in.nval;
		int i = 0;
		while(i < n && in.nextToken()!=StreamTokenizer.TT_EOF) {
			array[i++] = (int)in.nval;
		}
		out.println(minSum(0,n-1));
		out.flush();
		out.close();
		br.close();
	}
	
	public static long minSum(int l,int r) {
		if(l==r) return 0;
		int m = l + (r-l)/2;
		return minSum(l,m)+minSum(m+1,r)+merge(l,m,r);
	}
	
	public static long merge(int l,int m,int r) {
		// 统计左跨右产生的答案
		long ans = 0;
		long sum = 0;
		for(int j=m+1,i=l;j<=r;j++) {
			while(i<=m && array[i]<=array[j]) {
				sum += array[i++];
			}
			ans+=sum;
		}
		// 正常合并操作
		int ls = l,rs=m+1,index=l;
		while(ls <= m && rs <= r) {
			temp[index++] = array[ls]<=array[rs]?array[ls++]:array[rs++];
		}
		while(ls<=m) {
			temp[index++]=array[ls++];
		}
		while(rs<=r) {
			temp[index++]=array[rs++];
		}
		for(int i=l;i<=r;i++) {
			array[i]=temp[i];
		}
		return ans;
	}
}
