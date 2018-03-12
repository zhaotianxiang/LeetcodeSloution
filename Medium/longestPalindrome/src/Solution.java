/**
 * Simple to Introduction
 *
 * @Description:
 * @Author: ztx
 * @CreateDate: 2018/3/11 10:44
 * Copyright: Copyright (c) : ustc  2018
 */
public class Solution {
    public String longestPalindrome(String s) {
        //最长回文子串
        //情况1：若s为空或者s长度为1，则返回s
        if(s.isEmpty()||s.length()==1)
        {
            return s;
        }
        //情况2：若s不为空，设计算法
        //算法一：反转字符串，然后判断两个字符串的最长公共子串，并且检查他们的索引是否一致
        //算法二：暴风(Brute Force)算法，即蛮力查找算法，朴素模式串匹配算法O(n3)，会超时
        //算法三：动态规划(dynamic programming)
        //算法四：围绕中心展开 Expand Around Center 字符串有2n-1个中心，单个字符中心和双个字符中心
        int start = 0 ,end = 0;
        for(int i = 0; i < s.length();i++){
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            //len为返回中心的长度
            int len = Math.max(len1,len2);
            //返回的是最大的中心长度
            if(len>end-start){
                start = i - (len -1)/2;
                end = i + len/2;
            }
        }
        String result = s.substring(start,end);
        return result;
    }
    private int expandAroundCenter(String s, int left, int right) {
        //输入中心
        int L = left, R = right;
        //判断中心满足成为中心的条件，然后从中心不断展开直到不满足会问条件为止
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
