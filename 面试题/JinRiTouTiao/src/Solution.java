
public class Solution {
	//数组的反转,再次反转
	//巧妙之处是，转一次就会逆序，再次旋转就会顺序
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] str = {'w','w','w','.','j','i','r','i','t','o','u','t','i','a','o','.','c','o','m'};
		Solution(str);
		System.out.print(str);

	}
	//数组的中心旋转函数
	public static char[] convert(char[] str,int start,int end) {
		while(start < end) 
		{
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start ++;
			end --;
		}
		return str;
	}
	//根据情况不同的实施函数
	public static char[] Solution(char[] str) {
		convert( str, 0, str.length-1 );
		for(int i = 0,j = 0;i < str.length && j < str.length ;j ++) {
			if(str[j] != '.')
				continue;
			convert(str, i, j-1);
			i = j+1;
		}
		return str;
	}
}
