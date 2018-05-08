
/**
 * @author aliyang
 * @date 18-5-8 下午10:11
 * 两个链表的第一个公共结点：别人解法
 * 思路：长度相同有公共结点，第一次就遍历到；没有公共结点，走到尾部NULL相遇，返回NULL
 * 长度不同有公共结点，第一遍差值就出来了，第二遍一起到公共结点；没有公共，一起到结尾NULL。
 */
public class T_36 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode p1=pHead1;
        ListNode p2=pHead2;
        while (p1!=p2){
            p1=(p1==null?pHead2:p1.next);
            p2=(p2==null?pHead1:p2.next);
        }
        return p1;
    }

    public static void main(String[] args){
        T_36 t=new T_36();
        ListNode pHead1=new ListNode(1);
        ListNode real_pHead1=pHead1;
        ListNode pHead2=new ListNode(5);
        ListNode real_pHead2=pHead2;
        pHead1.next=new ListNode(2);
        pHead1=pHead1.next;
        ListNode intersect=new ListNode(3);
        pHead2.next=intersect;
        pHead1.next=intersect;
        pHead1=pHead1.next;
        pHead1.next=new ListNode(4);

        t.FindFirstCommonNode(real_pHead1,real_pHead2);


    }
}
