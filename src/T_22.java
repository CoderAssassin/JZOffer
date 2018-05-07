import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author aliyang
 * @date 18-5-7 下午3:58
 * 从上往下打印二叉树：我的解法
 * 思路：借助链队列
 * 注意：输入为{}的时候很坑，要输出空数组而不是null！！！！
 */
public class T_22 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null)
            return res;
        Queue queue=new LinkedList();
        ((LinkedList) queue).add(root);
        res=print_Tree(queue,res);
        return res;
    }

    private ArrayList<Integer> print_Tree(Queue queue,ArrayList<Integer> res){
        while (queue.isEmpty()==false){
            TreeNode root=(TreeNode) queue.poll();
            res.add(root.val);
            if (root.left!=null)
                ((LinkedList) queue).add(root.left);
            if (root.right!=null)
                ((LinkedList) queue).add(root.right);
        }
        return res;
    }

    public static void main(String[] args){
        T_22 t=new T_22();
        ArrayList<Integer> res=new ArrayList<>();
        TreeNode root=new TreeNode(1);
        TreeNode real_root=root;
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        TreeNode root1=root.left;
        TreeNode root2=root.right;
        root1.left=new TreeNode(4);
        root1.right=new TreeNode(5);

        res=t.PrintFromTopToBottom(null);

        for (int i=0;i<res.size();i++)
            System.out.print(res.get(i)+" ");
    }
}
