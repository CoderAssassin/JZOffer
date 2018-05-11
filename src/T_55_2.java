/**
 * @author aliyang
 * @date 18-5-11 下午10:52
 * 链表中环的入口节点：别人解法，断链法
 * 思路：
 * 时间复杂度为O（n），两个指针，一个在前面，另一个紧邻着这个指针，在后面。
 * 两个指针同时向前移动，每移动一次，前面的指针的next指向NULL。
 * 也就是说：访问过的节点都断开，最后到达的那个节点一定是尾节点的下一个，
 * 也就是循环的第一个。
 * 这时候已经是第二次访问循环的第一节点了，第一次访问的时候我们已经让它指向了NULL，
 * 所以到这结束
 */
public class T_55_2 {

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
        ListNode previous = pHead;
        ListNode front = pHead.next;
        while (front!=null)
        {
            previous.next = null;
            previous = front;
            front = front.next;
        }
        return previous;
    }
}
