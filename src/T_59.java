import java.util.*;

/**
 * @author aliyang
 * @date 18-5-12 上午10:46
 * 按之字形顺序打印二叉树：我的解法
 * 思路：用了不少辅助空间，主要是用到各个辅助状态变量，奇数层从头到尾存储，偶数层从尾到头存储
 *
 * 别人思路：没有开新的数组存对象，而是当遇到偶数的层的时候，从后往前遍历queue队列
 */
public class T_59 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot==null)
            return new ArrayList<ArrayList<Integer>>();

        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();

        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(pRoot);
        int[] num=new int[1];
        num[0]=pRoot.val;

        int seq=0;//表示是奇数行还是偶数行，0表示奇数行，从左到右；1表示偶数行，从右到左
        int seq_num=1;//表示当前行还有多少个节点
        int seq_nextnum=0;//表示接下来的一行由多少个节点
        int i=0;
        while (queue.isEmpty()==false){
            TreeNode tmp=queue.poll();
            int val=tmp.val;

            if (seq_num==0){//说明当前行已经遍历完
                seq=(seq==0?1:0);
                ArrayList<Integer> list=new ArrayList<>();
                for (int k=0;k<num.length;k++)
                    list.add(num[k]);
                res.add(list);
                num=new int[seq_nextnum];//下一行的数组
                seq_num=seq_nextnum;
                seq_nextnum=0;
                i=0;
            }

            //            将左右孩子节点加入队列，并更新下一行的节点数
            if (tmp.left!=null){
                queue.add(tmp.left);
                seq_nextnum++;
            }
            if (tmp.right!=null){
                queue.add(tmp.right);
                seq_nextnum++;
            }
            if (seq==0)//若是奇数行，从左到右存到数组
                num[i++]=val;
            else{//若是偶数行，从右到左存到数组
                num[seq_num-1]=val;
                i++;
            }

            seq_num--;
        }

        ArrayList<Integer> list=new ArrayList<>();
        for (int k=0;k<num.length;k++)
            list.add(num[k]);
        res.add(list);
        return res;
    }

    public static void main(String[] args){
        T_59 t=new T_59();
        TreeNode tree=new TreeNode(1);
        TreeNode real_tree=tree;

        tree.left=new TreeNode(2);
        tree.right=new TreeNode(3);

        ArrayList<ArrayList<Integer>> res=t.Print(real_tree);
        System.out.println(1);
    }
}
