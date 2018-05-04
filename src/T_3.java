import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-5-4 下午10:06
 * 打印链表:利用递归
 */
public class T_3 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<Integer> arrayList=new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if (listNode!=null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }



}
