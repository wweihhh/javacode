package bitetech.ds;


import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    //删除指定内容的结点
    public static ListNode removeElements(ListNode head, int val) {
        //有虚拟头节点
//        ListNode dummyHead=new ListNode(0);
//        dummyHead.next=head;
//        ListNode prev =dummyHead;
//        while (prev.next!=null){
//            if(prev.next.val==val){
//                prev.next=prev.next.next;
//            }else{
//                prev=prev.next ;
//            }
//        }
//        return dummyHead.next;
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
    //从中间节点输出
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (head != null) {
            count++;
            head = head.next;
        }
        int k = 0;
        k = count / 2 + 1;
        for (int i = 1; i < k; i++) {
            cur = cur.next;
        }
        return cur;
        //        ListNode cur1=head;
//        ListNode cur2=head;
//        while(cur1!=null&&cur1.next!=null){
//            cur1= cur1.next.next;
//            cur2 = cur2.next;
//        }
//        return cur2;
    }
    //从第k个结点输出
    public ListNode FindKthToTail(ListNode head, int k) {
//
//          int count = 0;
//          ListNode cur = head;
//          while(head!=null){
//              count++;
//              head=head.next;
//          }
//          if(k<0||k>count){
//              return null;
//          }
//          for(int i=0;i<count-k;count++){
//              cur=cur.next;
//          }
//          return cur;
        ListNode list1 = head;
        ListNode list2 = head;
        if (k <= 0) {
            return null;
        }
        for (int i = 1; i <= k; i++) {
            if (list1 != null) {
                list1 = list1.next;
            } else {
                return null;
            }
        }
        while (list1 != null) {
            list1 = list1.next;
            list2 = list2.next;
        }
        return list2;
    }
    //回文
    public boolean chkPalindrome(ListNode A) {
        if (A == null || A.next == null) {//链表空
            return true;
        }
        //链表至少有两个结点
        ListNode fast = A;
        ListNode low = A;
        while (fast != null && low != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        ListNode mid = low;//找到中间结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = mid;//只是让虚拟头结点指向mid，成为一个新的结点
        if (mid.val == A.val) {//没反转之前就相等
            return true;     //说明链表节点有两个  而且两个结点的val相同 如 1->1
        } else {
            if (mid.next == null) {//不等 且只有两个节点不是回文
                return false;
            }
        }
        //大于两个节点 则三指针翻转
        ListNode f = dummyHead.next;
        ListNode s = f.next;
        while (s != null) { //只要s不是空都可以进去 f->s最少可以换一次
            f.next = s.next;
            s.next = dummyHead.next;
            dummyHead.next = s;
            s = f.next;
        }
        fast=A;
        while(A!= null&&dummyHead.next!=null){
            if(A.val!=dummyHead.next.val){
                return false;
            }else {
                A=A.next;
                dummyHead.next=dummyHead.next.next;
            }
        }
        return true;

    }
    //反转链表
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        if(head==null||head.next==null){
            return head;
        }else {
            ListNode f=dummyHead.next;
            ListNode s=f.next;
            while(s!=null){
                f.next=s.next;
                s.next=dummyHead.next;
                dummyHead.next=s;
                s=f.next;
            }
            return dummyHead.next;
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(6);
        ListNode list5 = new ListNode(4);
        ListNode list6 = new ListNode(5);
        ListNode list7 = new ListNode(6);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list6;
        list6.next = list7;
        Solution solution=new Solution();
        ListNode list=ListNode.removeElements(list1,6);
        while(list!=null){
            System.out.print(list.val+"、");
            list = list.next;
        }
    }

}