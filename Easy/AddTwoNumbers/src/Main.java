import java.util.ServiceLoader;

/**
 * Simple to Introduction
 *
 * @Description: driver
 * @Author: ztx
 * @CreateDate: 2018/3/9 14:48
 * Copyright: Copyright (c)  2018ustc
 */
public class Main {
    public static void main(String [] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Slution slution = new Slution();
        slution.addTwoNumbers(l1,l2);
    }
}
