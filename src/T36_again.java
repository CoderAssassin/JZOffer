/**
 * @Author:Aliyang
 * @Data: Created in 下午3:35 18-7-2
 * 两个链表的第一个公共结点：二刷
 * 思路：总体还是双指针遍历，找处链表的差值
 **/
public class T36_again {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1==null||pHead2==null)
            return null;

        ListNode head1=pHead1,head2=pHead2;

        while (head1!=head2){
            head1=(head1==null?pHead2:head1.next);
            head2=(head2==null?pHead1:head2.next);
        }
        return head1;
    }

    public static void main(String[] args){
        T36_again t=new T36_again();
        ListNode pHead1=new ListNode(1);
        ListNode realPHead1=pHead1;
        pHead1.next=new ListNode(2);
        pHead1=pHead1.next;
        pHead1.next=new ListNode(3);
        ListNode pubNode=pHead1.next;
        pHead1=pHead1.next;
        pHead1.next=new ListNode(4);

        ListNode pHead2=new ListNode(5);
        ListNode realPHead2=pHead2;
        pHead2.next=pubNode;

        ListNode res=t.FindFirstCommonNode(realPHead1,realPHead2);
        System.out.println(res.val);
    }
}
