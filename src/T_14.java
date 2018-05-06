/**
 * @author aliyang
 * @date 18-5-6 下午3:55
 * 链表中倒数第k个节点:我的解法
 */
public class T_14 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null)
            return null;
        int count=1;
        ListNode tmp=head;
        while (head.next!=null){
            count++;
            head=head.next;
        }

        if (k>count)
            return null;

        for (int i=1;i<=count-k;i++)
            tmp=tmp.next;
        return tmp;

    }

    public static void main(String[] args){
        T_14 t=new T_14();
        ListNode head=new ListNode(1);
        ListNode a=head;
        head.next=new ListNode(2);
        head=head.next;
        head.next=new ListNode(3);
        head=head.next;
        head.next=new ListNode(4);
        head=head.next;
        head.next=new ListNode(5);
        head=head.next;
        ListNode res=t.FindKthToTail(a,1);
        System.out.println(res.val);
    }


}
