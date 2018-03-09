import java.util.HashSet;
import java.util.Set;

/**
 * Simple to Introduction
 *
 * @Description:
 * @Author: ztx
 * @CreateDate: 2018/3/9 16:43
 * Copyright: Copyright (c) : ustc  2018
 */

/**
 * 时间复杂度为O(n)的解决方法
 * 主要引入了Map<E> HashMap<>的容器，因为不重复的特性和一些好用的方法，可以减少时间复杂度
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {

        //第一种情况 空串
        if(s.isEmpty()){
            return 0;
        }
        //第二种情况 不为空串
        int sLength = s.length();
        int count = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < sLength;i++){
            for(int j = i;j<sLength;j++){
                if(!set.contains(s.charAt(j))){
                    //如果集合中没有，则加入集合
                    set.add(s.charAt(j));
                    if(set.size()>count){
                        count ++;
                    }
                }else{
                    set.clear();
                    break;
                }
            }
        }
        return count;
    }
}
