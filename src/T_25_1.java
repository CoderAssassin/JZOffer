/**
 * @author aliyang
 * @date 18-5-7 下午8:56
 * 复杂链表的复制：别人解法，思路很巧妙，学习！
 * 思路：1.复制每个节点，比如复制节点A得到A1，将A1插入节点A后面
 * 2.遍历链表，A1->random=A->random->next
 * 3.将链表拆分成原链表和复制后的链表
 */
public class T_25_1 {

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
        if (pHead==null)return null;

        RandomListNode tmp_pHead=pHead;
//        将所有的新的节点插入到原来的节点的后边
        while (tmp_pHead!=null){
            RandomListNode newNode=new RandomListNode(tmp_pHead.label);
            newNode.next=tmp_pHead.next;
            tmp_pHead.next=newNode;
            tmp_pHead=tmp_pHead.next;
        }
        tmp_pHead=pHead;
//        修改random指针
        while (tmp_pHead!=null){
            RandomListNode newNode=tmp_pHead.next;
            if (tmp_pHead.random!=null){
//                将新的节点的random指针指向原来节点的random指针的next
                newNode.random=tmp_pHead.random.next;
            }
            tmp_pHead=newNode.next;
        }
//        将链表拆分
        RandomListNode cloned=pHead.next;
        RandomListNode tmp=null;
        tmp_pHead=pHead;
        while (tmp_pHead.next!=null){
            tmp=tmp_pHead.next;
            tmp_pHead.next=tmp.next;
            tmp_pHead=tmp;
        }
        return cloned;

    }

}
