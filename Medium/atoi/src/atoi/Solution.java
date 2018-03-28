package atoi;

public class Solution {
	public int myAtoi(String str) {
		//�����ж������Ƿ�Ϊ�գ�����Ϊ�յ��쳣��Ϊ�����0
		if(str == null || str.isEmpty()) {
			return 0;
		}
		//���´���resultΪ����ֵ
		int result = 0;
		boolean negative = false;//��־λ
		int i = 0,len = str.length();
		int limit = -Integer.MAX_VALUE;//����Ϸ���������
		int multmin; //�����˷�����ʱ���ߵ��ĺϷ����ޣ����ޣ�
		int digit;//��ǰ��Ӧ������
		if(len > 0) {
			char firstChar = str.charAt(0);
			//����������
			if('-' == firstChar) {//����
				negative = true;
				limit = Integer.MIN_VALUE;
			}else if('+' != firstChar) {//����
				//����
				return 0;
			}
			if(len == 1)
				//����ֻ�з���
				return 0;
			i ++;
		}
		multmin = limit/10;//����ת���Ľ�����
		
		//��ʼ����
		while(i < len) {
			digit = str.charAt(i) - '0';
			if(digit < 0) {
				//������
				return 0;
			}
			if(result < multmin)//�˷����
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
