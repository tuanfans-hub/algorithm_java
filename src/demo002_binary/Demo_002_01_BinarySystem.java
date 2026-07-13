package demo002_binary;

import java.io.*;
import java.util.Arrays;

/**
 * @author TuanFans
 * @time 2025年11月30日 15:10:33
 * <p>将十进制转为二进制</p>
 */
public class Demo_002_01_BinarySystem {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		// 测试用例的个数
		in.nextToken();
		int n = (int)in.nval;
		// 二进制的最大位数
		in.nextToken();
		int bits = (int)in.nval;
		int max = (int)Math.pow(2, bits-1);
		int min = -(int)Math.pow(2, bits-1);
		int i = 0;
		while(i<n && in.nextToken() != StreamTokenizer.TT_EOF) {
			// 十进制数
			int number = (int)in.nval;
			i++;
			if(number > max || number < min) {
				out.println(number+"超出表示范围["+min+","+max+")");
			}else {
				out.println(number+"(10) 的二进制表示： "+toBinary(bits,number)+"(2)");
				out.println(number+"(10) 的二进制表示： "+toBinaryByMod(bits,number)+"(2)");
				out.println(number+"(10) 的二进制表示： "+toBinaryByBitwise(bits,number)+"(2)");
			}
		}
		out.flush();
		out.close();
		br.close();
	}

	/**
	 * 暴力实现
	 * @param bits 最大位数限制
	 * @param number 待转换的十进制数
	 * @return 二进制数的字符串
	 */
	public static String toBinary(int bits,int number) {
		boolean isLessZero = false;
		if(number < 0) {
			number = ~number + 1;// 得到number的相反数
			isLessZero = true;
		}
		char[] b = new char[bits];
		Arrays.fill(b, '0');
		for(int i = 0;i < bits;i++) {
			if(number==0) {
				break;
			}
			int cur = (int) Math.pow(2, bits-i-1);
			if(number>=cur) {
				b[i] = '1';
				number -= cur;
			}
		}
		// 对于负数的处理
		if(isLessZero) {
			// 符号位为1
			b[0] = '1';
			// 数值位取反+1
			for(int i = 1;i < bits;i++) {
				b[i] = b[i]=='0'?'1':'0';
			}
			boolean carry = true;
			for(int i = bits-1;i>0 && carry;i--) {
				if(b[i]=='0') {
					b[i] = '1';
					carry = false;
				}else {
					b[i] = '0';
				}
			}
		}
		return new String(b);
	}
	
	/**
	 * 除二取余法：对待负数需要额外处理
	 * @param bits 最大位数限制
	 * @param number 十进制数
	 * @return 二进制数的字符串
	 */
	public static String toBinaryByMod(int bits,int number) {
		boolean isLessZero = false;
		if(number < 0) {
			number = ~number + 1;
			isLessZero = true;
		}
		char[] bi = new char[bits];
		Arrays.fill(bi, '0');
		// 对于正数：除二取余法
		int curIndex = bits-1;
		while(number != 0) {
			bi[curIndex--] = number%2==0?'0':'1';
			number /= 2;
		}
		// 对于负数的处理
		if(isLessZero) {
			bi[0] = '1';
			for(int i = 1;i < bits;i++) {
				bi[i] = bi[i]=='1'?'0':'1';
			}
			boolean carry = true;
			for(int i = bits-1;i>0 && carry;i--) {
				if(bi[i]=='0') {
					bi[i] = '1';
					carry = false;
				}else {
					bi[i] = '0';
				}
			}
		}
		return new String(bi);
	}
	
	/**
	 * 位运算实现：对于正负数都适用
	 * @param bits 最大位数限制
	 * @param number 十进制数
	 * @return 二进制数的字符串
	 */
	public static String toBinaryByBitwise(int bits,int number) {
		char[] bi = new char[bits];
		for(int i = bits-1;i >= 0;i--) {
			bi[i] = (number&1)==0?'0':'1';
			// 使用>>或>>>都可以
			number = number >> 1;
		}
		return new String(bi);
	}
}
