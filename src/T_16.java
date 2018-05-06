/**
 * @author aliyang
 * @date 18-5-6 下午4:50
 * 合并两个排序的链表：我的解法
 */
public class T_16 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {

        if (list1==null)
            return list2;
        else if (list2==null)
            return list1;

        ListNode first=new ListNode(0);//第一个数小的
        ListNode second=new ListNode(0);//第一个数大的
        if (list1.val<=list2.val){
            first.next=list1;
            second.next=list2;
        }else {
            first.next=list2;
            second.next=list1;
        }
        ListNode res=first.next;

        ListNode pre=first;
        first=first.next;
        second=second.next;
        while (first!=null){
            while (second!=null){
                if (first.val>second.val){
                    ListNode next=second;//待插入的节点
                    second=second.next;
                    next.next=first;
                    pre.next=next;
                    pre=next;
                }else break;
            }
            if (second==null)
                break;
            pre=first;
            first=first.next;
        }

        if (second!=null){
            pre.next=second;
        }

        return res;
    }

    public static void main(String[] args){
        T_16 t=new T_16();
        T_16.ListNode head=new T_16.ListNode(1);
        T_16.ListNode a=head;
        head.next=new T_16.ListNode(1);
        head=head.next;
        head.next=new T_16.ListNode(1);
        head=head.next;
        head.next=new T_16.ListNode(2);
        head=head.next;
        head.next=new T_16.ListNode(2);
        head=head.next;

        T_16.ListNode head1=new T_16.ListNode(1);
        T_16.ListNode b=head1;
        head1.next=new T_16.ListNode(1);
        head1=head1.next;
        head1.next=new T_16.ListNode(1);
        head1=head1.next;
        head1.next=new T_16.ListNode(4);
        head1=head1.next;
        head1.next=new T_16.ListNode(4);
        head1=head1.next;

        ListNode res=null;

        res=t.Merge(a,b);



        while (res.next!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }

}
