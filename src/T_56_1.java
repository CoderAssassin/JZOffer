/**
 * @author aliyang
 * @date 18-5-12 上午12:09
 * 删除链表中重复的节点：别人解法
 * 思路：递归
 */
public class T_56_1 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null)
            return null;
        if (pHead!=null && pHead.next==null)
            return pHead;

        ListNode current;

        if ( pHead.next.val==pHead.val){
            current=pHead.next.next;
            while (current != null && current.val==pHead.val)
            current=current.next;
            return deleteDuplication(current);
        }

        else {
            current=pHead.next;
            pHead.next=deleteDuplication(current);
            return pHead;
        }
    }
}
