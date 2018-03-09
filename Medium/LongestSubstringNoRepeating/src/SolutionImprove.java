import java.util.HashSet;
import java.util.Set;

/**
 * Simple to Introduction
 *
 * @Description:
 * @Author: ztx
 * @CreateDate: 2018/3/9 17:20
 * Copyright: Copyright (c) : ustc  2018
 */

/**
 * 算法时间复杂度O(n)
 * 思想：使用两个下标指针，申请一个无重复集合。
 * 两个指针分别在头和尾部，尾部不断加入集合，若有重复则从头部一个个删除
 * 直到头部没有删至集合无重复才继续
 */
public class SolutionImprove {
    public int lengthOfLongestSubstring(String s) {
        //我们不断向集合里面加值
        int sLength = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0,j = 0, count = 0;
        while( i < sLength && j < sLength){
            if(!set.contains(s.charAt(i))){
                //集合中是否有i下标的字符串
                set.add(s.charAt(i));
                i++;
                //考虑到没必要将每一个i值都进行这样的判断
                //也就是模式串匹配算法的思想，进行滑动
                 count = Math.max(count, i - j);
            }else{
                //移除最开始的值也就是移除j
                set.remove(s.charAt(j));
                j++;
            }
        }
        return count;
    }
}
