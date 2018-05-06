/**
 * @author aliyang
 * @date 18-5-6 下午7:17
 * 合并两个排序的列表：别人做法，递归学习下
 * 思路：递归
 */
public class T_16_1 {

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
        if (list2==null)
            return list1;

        if (list1.val<list2.val){
            list1.next=Merge(list1.next,list2);
            return list1;
        }else {
            list2.next=Merge(list1,list2.next);
            return list2;
        }
    }
}
