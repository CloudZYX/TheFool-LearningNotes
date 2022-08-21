package com.zyx.leetcode;

/**
 * LeetCode 002 两数相加
 * tag:链表，模拟
 * 
 * 给你两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 */
public class Num002_AddTwoNum{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode tem = first; 
        int carryBit = 0;
        while (l1 != null || l2 != null) {
            int i1 = l1 != null ? l1.val : 0;
            int i2 = l2 != null ? l2.val : 0;
            int res = i1 + i2 + carryBit;
            carryBit = 0;
            
            if (res >= 10) {
                carryBit = carryBit + res / 10;
                res = res % 10;
            }
            tem.next = new ListNode(res);
            tem = tem.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carryBit != 0) {
            tem.next = new ListNode(carryBit);
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(new int[]{2,4,3});
        ListNode l2 = ListNode.buildListNode(new int[]{5,6,4});
        ListNode res = addTwoNumbers(l1, l2);
        ListNode.printListNode(res);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void printListNode (ListNode ln) {
        while (ln != null) {
            System.out.print(ln.val);
            System.out.print(" ");
            ln = ln.next;
        }
    }

    public static ListNode buildListNode (int[] nums) {
        ListNode first = new ListNode(0);
        ListNode tem = first;
        for (int i : nums) {
            tem.next = new ListNode(i);
            tem = tem.next;
        }
        return first.next;
    }
}
