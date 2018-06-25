/**
 * @Author:Aliyang
 * @Data: Created in 下午5:00 18-6-25
 * 链表中倒数第k个结点：二刷
 * 思路：快慢指针，快指针先走k步，再两个指针一起走，最后慢指针的下一个就是，有几个特殊情况处理下
 **/
public class T14_again {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {

        ListNode fast=head;
        ListNode slow=head;

        for (int i=0;i<k;i++){//快指针先走k步
            if (fast!=null)
                fast=fast.next;
            else return null;
        }
        if (fast==null)//正好找的第一个
            return slow;

        while (fast!=null&&fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow.next;
    }
}
