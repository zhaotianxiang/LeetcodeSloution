import java.util.ArrayList;
import java.util.List;

/**
 * Simple to Introduction
 *
 * @Description:
 * @Author: ztx
 * @CreateDate: 2018/3/10 10:43
 * Copyright: Copyright (c) : ustc  2018
 */
public class Solution {
    /**
     *
     * @param nums1 sorted
     * @param nums2 sorted
     * @return double median
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        List<Integer> temp = new ArrayList<>();
        //将两个有序数组合并成一个有序数组，然后存入数组中
        //本例时间复杂度太高
        //特殊情况1：数组为空
        if(nums1Length == 0){
            //数组1为空
            double result =0d;
            if(nums2Length%2 == 0)
            {
                int i = nums2Length/2;
                //利用编译器的自动类型转换，减少复杂
                result = (nums2[i] + nums2[i-1])/2.0;
            }
            if(nums2Length%2 == 1)
            {
                result = nums2[nums2Length/2];
            }
            return result;
        }
        if(nums2Length == 0){
            //数组2为空
            double result =0d;
            if(nums1Length%2 == 0)
            {
                int i = nums1Length/2;
                result = (nums1[i] + nums1[i-1])/2.0;
            }
            if(nums1Length%2 == 1)
            {
                result = nums1[nums1Length/2];
            }
            return result;
        }
        //特殊情况2： 列取某组最大的比最小的小 下面有数组越界的可能
        if(nums1[nums1Length-1] < nums2[0]){
            //数组2中的值全部大于数组1
           for(int i = 0;i<nums1Length;i++){
               temp.add(nums1[i]);
           }
           for(int j = 0;j<nums1Length;j++){
               temp.add(nums2[j]);
           }
        }else if(nums2[nums2Length-1] < nums1[0]){
            //数组1中的值全部大于数组2
            for(int j = 0;j<nums1Length;j++){
                temp.add(nums2[j]);
            }
            for(int i = 0;i<nums1Length;i++){
                temp.add(nums1[i]);
            }
        }
        //一般情况处理
        int i=0,j=0;
        while(i < nums1Length || j < nums2Length){

            //注意判断数组越界错误,当某一个数组越界后马还是那个跟着处理，不能在访问了
            if(j >= nums2Length){
                temp.add(nums1[i++]);
            }else if(i >= nums1Length){
                temp.add(nums2[j++]);
            }else if(nums1[i]<nums2[j]){
                temp.add(nums1[i++]);
            }else if(nums1[i]>=nums2[j]){
                temp.add(nums2[j++]);
            }
        }
        if(temp.size() == 0){
            return 0;
        }
        //数组长度为偶数
        double result = 0d;
        if(temp.size()%2 == 0){
            int right = temp.size()/2;
            int left = right - 1;
            //注意indexOf(left)是找出索引
            // temp.get()是根据索引找出值
            double value = temp.get(left)+temp.get(right);
            result = value/2.0;
        }else if((temp.size()%2 == 1)){
            result = temp.get(temp.size()/2);
        }
        return result;
    }
}
