import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author aliyang
 * @date 18-5-11 下午10:07
 * 链表中环的入口节点：我的解法
 * 思路：用集合保存访问过得节点，当碰到节点在集合中已经存在，那么返回该节点
 */
public class T_55 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    Set<ListNode> set=new LinkedHashSet<>();
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead.next==null)
            return null;
        if (pHead.next==pHead||pHead.next.next==pHead)
            return pHead;

        while (true){
            if (pHead.next==null)
                return null;
            set.add(pHead);
            pHead=pHead.next;
            if (set.contains(pHead))
                return pHead;
        }
    }

    public static void main(String[] args){
        T_55 t=new T_55();
        ListNode list=new ListNode(1);
        ListNode real_list=list;
        list.next=new ListNode(2);
        list=list.next;
        ListNode first=list;
        list.next=new ListNode(3);
        list=list.next;
        list.next=new ListNode(4);
        list=list.next;
        list.next=first;

        ListNode res=t.EntryNodeOfLoop(real_list);
        System.out.println(res.val);

    }

}
