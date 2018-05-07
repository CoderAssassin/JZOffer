/**
 * @author aliyang
 * @date 18-5-7 下午7:36
 * 复杂链表的复制：我的解法
 * 思路：首先建立next指针的整条链，然后对每个原节点的random指针，找到原来的random指针指向的是第几个节点，
 * 在新的链路中也指向对应位置的节点。方法中用到了几个辅助的节点。
 */
public class T_25 {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return String.valueOf(label);
        }
    }

    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead==null) return null;
        RandomListNode res=new RandomListNode(pHead.label);
        RandomListNode real_res=res;
        RandomListNode real_pHead=pHead;
//        修改next指针
        while (pHead.next!=null){
            pHead=pHead.next;
            RandomListNode then=new RandomListNode(pHead.label);
            res.next=then;
            res=res.next;
        }

//        指针再指到每个的头
        res=real_res;
        pHead=real_pHead;
//        修改随机指针
        while (real_res.next!=null){
            RandomListNode tmp_pHead=pHead;
            int index=1;//用来计算random指向的是头节点开始往后第几个节点
            if (real_pHead.random==null){//若原来的random指向的就是null，那么直接继续
                real_res=real_res.next;
                real_pHead=real_pHead.next;
                continue;
            }
            while (tmp_pHead!=real_pHead.random){//找到原来的random指向的是头节点往后第几个节点
                tmp_pHead=tmp_pHead.next;
                index++;
            }
            RandomListNode tmp_res=res;
            for (int i=1;i<index;i++)//找到新链表中random对应的节点
                tmp_res=tmp_res.next;
            real_res.random=tmp_res;//建立节点链接
            real_res=real_res.next;
            real_pHead=real_pHead.next;
        }

        return res;
    }

    public static void main(String[] args){
        T_25 t=new T_25();
        RandomListNode head=new RandomListNode(1);
        RandomListNode real_head=head;
        RandomListNode next1=new RandomListNode(2);
        head.next=next1;
        head=head.next;
        RandomListNode next2=new RandomListNode(3);
        head.next=next2;
        head=head.next;
        RandomListNode next3=new RandomListNode(4);
        head.next=next3;
        head=head.next;
        RandomListNode next4=new RandomListNode(5);
        head.next=next4;

        real_head.random=next2;
        next1.random=next4;
        next3.random=next1;

        RandomListNode res=t.Clone(real_head);

        System.out.println(res.toString());
    }
}
