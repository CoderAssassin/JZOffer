/**
 * @author aliyang
 * @date 18-5-10 下午8:59
 * 孩子们的游戏(圆圈中最后剩下的数)：我的解法
 * 思路：使用循环单列表，可以改成双链表，可以用数组模拟环
 */
public class T_46 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public int LastRemaining_Solution(int n, int m) {

        if (n==0||n==1||m==0)
            return -1;

        ListNode list=new ListNode(0);
        ListNode real_list=list;
        for (int i=1;i<n;i++){
            list.next=new ListNode(i);
            list=list.next;
        }
        list.next=real_list;

        int count=0;
        ListNode pre=list;
        while (real_list.next!=real_list){
            if (count==m-1){
                pre.next=real_list.next;
                real_list=real_list.next;
                count=0;
                continue;
            }
            count++;
            pre=real_list;
            real_list=real_list.next;
        }
        return real_list.val;
    }

    public static void main(String[] args){
        T_46 t=new T_46();
        System.out.println(t.LastRemaining_Solution(11,3));

    }

}
