/**
 * Simple to Introduction
 *
 * @Description:
 * @Author: ztx
 * @CreateDate: 2018/3/10 10:43
 * Copyright: Copyright (c) : ustc  2018
 */
public class Main {
    public static void main(String [] args){
        Solution solution = new Solution();
        int [] num1 = {};
        int [] num2 = {1,2};
        double median = solution.findMedianSortedArrays(num1,num2);
        System.out.println(median);
    }
}
