package atoi;

public class Solution {
	public int myAtoi(String str) {
		//首先判断输入是否为空，或者为空的异常，为空输出0
		if(str == null || str.isEmpty()) {
			return 0;
		}
		//以下处理，result为返回值
		int result = 0;
		boolean negative = false;//标志位
		int i = 0,len = str.length();
		int limit = -Integer.MAX_VALUE;//结果合法的上下限
		int multmin; //在做乘法计算时能走到的合法上限（下限）
		int digit;//当前对应的数字
		if(len > 0) {
			char firstChar = str.charAt(0);
			//处理正负号
			if('-' == firstChar) {//负数
				negative = true;
				limit = Integer.MIN_VALUE;
			}else if('+' != firstChar) {//正数
				//出错
				return 0;
			}
			if(len == 1)
				//出错，只有符号
				return 0;
			i ++;
		}
		multmin = limit/10;//除以转换的进制数
		
		//开始处理
		while(i < len) {
			digit = str.charAt(i) - '0';
			if(digit < 0) {
				//非数字
				return 0;
			}
			if(result < multmin)//乘法溢出
			{
				return 0;
			}
			result *= 10;
			if(result < limit + digit) {
				return 0;
			}
			result -= digit;
		}
		
		
		return result;
	}
}
