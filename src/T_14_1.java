import java.util.List;

/**
 * @author aliyang
 * @date 18-5-6 下午4:25
 * 链表中倒数第k个节点:别人解法，很经典
 * 思路：利用两个指针，第一个指针先走k-1步，然后两个指针一起往后走，当第一个指针的下一个是null，
 * 那么第二个指针指向的就是倒数第k个
 */
public class T_14_1 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null||k==0)
            return null;

        ListNode first=head,second=head;//定义两个指针

        for (int i=1;i<=k-1;i++){
            if (first.next==null)//k超了
                return null;
            first=first.next;
        }

        while (first.next!=null){
            first=first.next;
            second=second.next;
        }
        return second;
    }
    public static void main(String[] args){
        T_14 t=new T_14();
        T_14.ListNode head=new T_14.ListNode(1);
        T_14.ListNode a=head;
        head.next=new T_14.ListNode(2);
        head=head.next;
        head.next=new T_14.ListNode(3);
        head=head.next;
        head.next=new T_14.ListNode(4);
        head=head.next;
        head.next=new T_14.ListNode(5);
        head=head.next;
        T_14.ListNode res=t.FindKthToTail(a,1);
        System.out.println(res.val);
    }

}
