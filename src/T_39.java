/**
 * @author aliyang
 * @date 18-5-9 下午4:16
 * 平衡二叉树：我的解法
 * 思路：计算左右子树深度差
 */
public class T_39 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {

        if (root==null)
            return true;

        int left=1,right=1;
        if (root.left!=null)
            left=TreeDepth(root.left);
        if (root.right!=null)
            right=TreeDepth(root.right);

        if (Math.abs(left-right)>1)
            return false;
        else return true;
    }

    private int TreeDepth(TreeNode root) {

        if (root==null) return 0;
        return Math.max(TreeDepth(root.left)+1,TreeDepth(root.right)+1);
    }

    public static void main(String[] args){
        T_39 t=new T_39();

        TreeNode root1=new TreeNode(1);
        TreeNode real_root1=root1;
        root1.left=new TreeNode(1);
        root1.right=new TreeNode(2);
        root1=root1.left;
        root1.left=new TreeNode(1);

        System.out.println(t.IsBalanced_Solution(real_root1));

    }
}
