/**
 * @author aliyang
 * @date 18-5-11 下午10:42
 * 链表中环的入口节点：别人解法，用一快一慢两个指针
 * 思路：
 * 两个指针一个fast、一个slow同时从一个链表的头部出发
 * fast一次走2步，slow一次走一步，如果该链表有环，两个指针必然在环内相遇
 * //此时只需要把其中的一个指针重新指向链表头部，另一个不变（还在环内），
 * //这次两个指针一次走一步，相遇的地方就是入口节点。
 */
public class T_55_1 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

//找到一快一慢指针相遇处的节点，相遇的节点一定是在环中
    public ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        if(fast == null || fast.next == null)
            return null;
        fast = pHead;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
