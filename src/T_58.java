import java.util.ArrayList;
import java.util.List;

/**
 * @author aliyang
 * @date 18-5-12 上午9:40
 * 对称二叉树：我的解法
 * 思路：分别用列表存储根的左子树的节点的值和节点的方向，左子树的遍历左右顺序和右子树的遍历的
 * 左右顺序正好相反，最后得到的序列的值应该是一一对应的，但是方向正好是相反的
 */
public class T_58 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot==null)
            return true;

        if ((pRoot.left==null&&pRoot.right!=null)||
                (pRoot.left!=null&&pRoot.right==null))//如果根的左右不对称，直接输出
            return false;

//        记录值
        ArrayList<Integer> left_Seq=new ArrayList<>();
        ArrayList<Integer> right_Seq=new ArrayList<>();

//        记录是左节点还是右节点
        ArrayList<Integer> left_dir=new ArrayList<>();
        ArrayList<Integer> right_dir=new ArrayList<>();


        left_traverse(pRoot.left,left_Seq,left_dir,0);
        right_traverse(pRoot.right,right_Seq,right_dir,1);

        if (left_Seq.size()!=right_Seq.size())//如果大小不等直接false
            return false;
        for (int i=0;i<left_Seq.size();i++){
            if (left_Seq.get(i)!=right_Seq.get(i))//如果值不相等直接false
                return false;
            else {
                if (left_dir.get(i)==right_dir.get(i))//因为存的时候是存的镜像的顺序，所以如果相等说明不对称
                    return false;
            }
        }

        return true;
    }

//    遍历根的左子树
    private void left_traverse(TreeNode pRoot,List seq,List dir,int direction){

        if (pRoot==null)
            return;

        seq.add(pRoot.val);
        dir.add(direction);
        left_traverse(pRoot.left,seq,dir,0);
        left_traverse(pRoot.right,seq,dir,1);
    }

//    遍历根的右子树
    private void right_traverse(TreeNode pRoot,List seq,List dir,int direction){

        if (pRoot==null)
            return;

        seq.add(pRoot.val);
        dir.add(direction);
        left_traverse(pRoot.right,seq,dir,1);
        left_traverse(pRoot.left,seq,dir,0);
    }

    public static void main(String[] args){
        T_58 t=new T_58();
        TreeNode tree=new TreeNode(5);
        TreeNode real_tree=tree;
        tree.left=new TreeNode(5);
        tree.right=new TreeNode(5);
        TreeNode left=tree.left;
        TreeNode right=tree.right;
        left.left=new TreeNode(5);
//        left.right=new TreeNode(5);
        right.left=new TreeNode(5);
//        right.right=new TreeNode(5);

        System.out.println(t.isSymmetrical(real_tree));

    }
}
