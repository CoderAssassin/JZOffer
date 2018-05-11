/**
 * @author aliyang
 * @date 18-5-11 下午11:27
 * 删除链表中重复的节点：我的解法
 * 思路：从头到尾遍历，将重复的删除，设了个头结点
 *
 * 别人思路一：加个头结点，设两个指针，找前后不相等的节点，然后直接改指针
 */
public class T_56 {

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
        if (pHead.next==null)
            return pHead;
        ListNode tmp_pHead=pHead;

        ListNode first=new ListNode(-1);
        ListNode res=first;
        first.next=tmp_pHead;
        ListNode second=tmp_pHead;

        boolean dupl=false;//是否出现重复
        while (second.next!=null){
            if (second.next.val==second.val){
                dupl=true;
                second.next=second.next.next;
            }else if (second.next==null&&dupl==true)
                first.next=null;
            else if (second.next!=null&&second.val!=second.next.val&&dupl==true) {
                first.next = second.next;
                second=first.next;
                dupl=false;
            }else {
                first=second;
                second=second.next;
            }
        }
        if (dupl==true)
            first.next=second.next;

        return res.next;
    }

    public static void main(String[] args){
        T_56 t=new T_56();
        ListNode pHead=new ListNode(1);
        ListNode real_pHead=pHead;
        pHead.next=new ListNode(2);
        pHead=pHead.next;
        pHead.next=new ListNode(3);
        pHead=pHead.next;
        pHead.next=new ListNode(3);
        pHead=pHead.next;
        pHead.next=new ListNode(4);
        pHead=pHead.next;
        pHead.next=new ListNode(4);
        pHead=pHead.next;
        pHead.next=new ListNode(5);
        pHead=pHead.next;

        real_pHead=t.deleteDuplication(real_pHead);
        while (real_pHead.next!=null){
            System.out.println(real_pHead.val+" ");
            real_pHead=real_pHead.next;
        }

    }
}
