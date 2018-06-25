/**
 * @Author:Aliyang
 * @Data: Created in 下午7:48 18-6-25
 * 复杂链表的复制：二刷
 * 思路：复制每个节点连到其后边，然后更新新节点的随机指针，最后拆开链表
 **/
public class T25_again {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead==null)
            return null;

//        再每个节点后插入随机指针指向的节点
        RandomListNode realHead=pHead;
        while (pHead!=null){
            RandomListNode tmp=pHead.next;
            RandomListNode newNode=new RandomListNode(pHead.label);
            newNode.next=pHead.next;
            pHead.next=newNode;
            pHead=tmp;
        }

        pHead=realHead;
        while (pHead!=null){
            RandomListNode newNode=pHead.next;
            if (pHead.random!=null)
                newNode.random=pHead.random.next;
            pHead=newNode.next;
        }

//       拆分链表
        RandomListNode cloned=realHead.next;
        RandomListNode tmp=null;
        pHead=realHead;
        while (pHead.next!=null){
            tmp=pHead.next;
            pHead.next=tmp.next;
            pHead=tmp;
        }
        return cloned;

    }

    public static void main(String[] args){
        T25_again t=new T25_again();
        RandomListNode node1=new RandomListNode(1);
        RandomListNode realPHead=node1;
        RandomListNode node2=new RandomListNode(2);
        node1.next=node2;
        RandomListNode node3=new RandomListNode(3);
        node2.next=node3;
        RandomListNode node4=new RandomListNode(4);
        node3.next=node4;
        node1.random=node4;
        node3.random=node1;
        RandomListNode res=t.Clone(realPHead);
        System.out.println(1);
    }
}
