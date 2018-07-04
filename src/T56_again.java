/**
 * @Author:Aliyang
 * @Data: Created in 下午2:18 18-7-4
 * 删除链表中重复的结点：二刷
 **/
public class T56_again {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null||pHead.next==null)
            return pHead;

        ListNode tmp=new ListNode(-1);
        ListNode realTmp=tmp;
        if (pHead.val==pHead.next.val){
            ListNode unDup=pHead.next;//找到第一个和当前节点不一样的节点
            while (unDup!=null&&pHead.val==unDup.val)
                unDup=unDup.next;
            tmp.next= deleteDuplication(unDup);
        }
        else{
            tmp.next=pHead;//当前节点接上
            tmp=tmp.next;
            tmp.next= deleteDuplication(pHead.next);
        }

        return realTmp.next;
    }

    public static void main(String[] args){
        T56_again t=new T56_again();
        ListNode pHead=new ListNode(1);
        ListNode realPHead=pHead;
        pHead.next=new ListNode(2);
        pHead=pHead.next;
        pHead.next=new ListNode(3);
        pHead=pHead.next;
        pHead.next=new ListNode(3);
        pHead=pHead.next;
        pHead.next=new ListNode(4);
        pHead=pHead.next;
        pHead.next=new ListNode(5);
        ListNode res=t.deleteDuplication(realPHead);
        while (res!=null){
            System.out.print(res.val+",");
            res=res.next;
        }
    }
}
