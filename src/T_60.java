import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author aliyang
 * @date 18-5-12 下午2:09
 * 把二叉树打印成多行：我的解法
 * 思路：和上题基本类似，层次遍历
 */
public class T_60 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        if (pRoot==null)
            return new ArrayList<ArrayList<Integer>>();

        LinkedList<TreeNode> queue=new LinkedList();
        queue.add(pRoot);
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();

        int nowSize=1;//当前层大小
        int nextSize=0;//下一层大小

        while (queue.isEmpty()==false){

            TreeNode tmp=queue.poll();
            int val=tmp.val;

            if (nowSize==0){
                res.add(list);
                list=new ArrayList<>();
                nowSize=nextSize;
                nextSize=0;
            }

            list.add(val);

            if (tmp.left!=null){
                queue.add(tmp.left);
                nextSize++;
            }
            if (tmp.right!=null){
                queue.add(tmp.right);
                nextSize++;
            }
            nowSize--;
        }
        res.add(list);

        return res;
    }

    public static void main(String[] args){
        T_60 t=new T_60();

        TreeNode tree=new TreeNode(1);
        TreeNode real_tree=tree;

        tree.left=new TreeNode(2);
        tree.right=new TreeNode(3);

        ArrayList<ArrayList<Integer>> res=t.Print(real_tree);
        System.out.println(1);


    }
}
