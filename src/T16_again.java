/**
 * @Author:Aliyang
 * @Data: Created in 下午5:07 18-6-25
 * 合并两个排序的链表：二刷
 * 思路：递归求解即可
 **/
public class T16_again {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {

        if (list1==null)
            return list2;
        if (list2==null)
            return list1;

        if (list1.val<=list2.val){
            list1.next=Merge(list1.next,list2);
            return list1;
        }
        else{
            list2.next=Merge(list1,list2.next);
            return list2;
        }
    }
}
