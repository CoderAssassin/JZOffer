/**
 * @Author:Aliyang
 * @Data: Created in 下午4:06 18-7-3
 * 链表中环的入口结点：二刷
 **/
public class T55_again {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead==null)
            return null;

        ListNode fast=pHead,slow=pHead;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow)
                break;
        }
        if (fast==null||fast.next==null)
            return null;
        fast=pHead;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
