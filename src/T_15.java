/**
 * @author aliyang
 * @date 18-5-6 下午4:39
 * 反转链表：我的解法
 * 思路：起码两个节点开始，然后改下指针
 */
public class T_15 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head==null)
            return null;
        if (head.next==null)
            return head;

        ListNode first=head;
        ListNode second=head.next;
        first.next=null;

        head=second;

        while (head.next!=null){

            ListNode next=head.next;

            second.next=first;
            first=second;
            second=next;
            head=next;
        }

        second.next=first;

        return second;
    }

    public static void main(String[] args){
        T_15 t=new T_15();
        T_15.ListNode head=new T_15.ListNode(1);
        T_15.ListNode a=head;
        head.next=new T_15.ListNode(2);
        head=head.next;
        head.next=new T_15.ListNode(3);
        head=head.next;
        head.next=new T_15.ListNode(4);
        head=head.next;
        head.next=new T_15.ListNode(5);
        head=head.next;
        T_15.ListNode res=t.ReverseList(a);

        while (res.next!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }

}
