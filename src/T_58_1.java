/**
 * @author aliyang
 * @date 18-5-12 上午10:41
 * 对称的二叉树：别人解法
 * 思路：利用递归，思路和我差不多，但递归写的好
 */
public class T_58_1 {

    public class TreeNode {
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
        return comRoot(pRoot.left,pRoot.right);
    }

    private boolean comRoot(TreeNode left,TreeNode right){
        if (left==null) return right==null;
        if (right==null) return false;
        if (left.val!=right.val) return false;
        return comRoot(left.right,right.left)&&comRoot(left.left,right.right);
    }
}
