/**
 * Simple to Introduction
 *
 * @Description:
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 *
 * @Author: ztx
 * @CreateDate: 2018/3/9 14:49
 * Copyright: Copyright (c): ustc 2018
 */
public class Slution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode current = dummyHead;

        int flag = 0;

        while(p != null || q != null){
            int x = (p!=null )? p.val : 0;
            int y = (q!=null )? q.val : 0;

            int sum = x + y + flag;
            flag = sum/10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            //空指针可以赋值给别人，但是空指针不能接受值。
            if(p!=null)
                p = p.next;
            if(q!=null)
                q = q.next;

        }
        if(flag > 0){
            current.next = new ListNode(flag);
        }
        return dummyHead.next;
    }
}
