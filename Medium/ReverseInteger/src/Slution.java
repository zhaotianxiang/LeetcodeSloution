import java.util.Stack;

/**
 * Simple to Introduction
 *
 * @Description: Given a 32-bit signed integer, reverse digits of an integer.
 * @Author: ztx
 * @CreateDate: 2018/3/9 15:17
 * Copyright: Copyright (c) : ustc  2018
 */

/**
 * 这题的解法主要是判断两个问题
 * 1. x值的正负问题，首先直接转换成正数
 * 2. 两个正数相加的overflow问题
 */
public class Slution {
    public int reverse(int x){
        int Flag = (x > 0)? 1 : -1;
        //保证xValue的值是正数
        int MAX_INT = 2147483647;
        int MIN_INT = -2147483648;
        if(x>=MAX_INT ||x<=MIN_INT){
            return 0;
        }
        int xValue = 0;
        if(Flag<=0){
            xValue = -x;
        }else{
            xValue = x;
        }
        //巧妙的引入了栈结构
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int item = xValue;
        //将值全部存入栈中
        while(item != 0){
            stack.push(item % 10);
            item = item / 10;
        }
        int count = 0;
        while(!stack.isEmpty()){
            item = stack.pop();
            /**
             * 此处处理overflow的问题，32位系统中，Integer.MAX_VALUE (2147483647)
             * 引入java中两数相加的函数java.lang.Math#addExact(int, int)
             */
            try{
                //这两句话可能就溢出了
                java.lang.Math.multiplyExact(count,10);
                int left = java.lang.Math.multiplyExact(item , power(count,10));
                result = java.lang.Math.addExact(result,left);
            }catch (ArithmeticException ae) {
                return 0;
            }
            count ++;
        }
        return result*Flag;
    }

    private int power(int count, int number) {
        int result = 1;
        for(int i = 1; i <= count ;i++){
            result = java.lang.Math.multiplyExact(10 ,result);
        }
        return result;
    }
}
