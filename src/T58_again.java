/**
 * @Author:Aliyang
 * @Data: Created in 下午2:42 18-7-4
 * 对称的二叉树：二刷
 **/
public class T58_again {

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
        return judge(pRoot.left,pRoot.right);
    }

    private boolean judge(TreeNode left,TreeNode right){

        if (left==null&&right==null)
            return true;
        if ((left==null&&right!=null)||(left!=null&&right==null))
            return false;
        if (left.val!=right.val)
            return false;

        if (judge(left.left,right.right)&&judge(left.right,right.left))
            return true;
        return false;
    }
}
