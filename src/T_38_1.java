/**
 * @author aliyang
 * @date 18-5-9 下午4:07
 * 二叉树的深度：别人解法
 * 最短的递归
 */
public class T_38_1 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public int TreeDepth(TreeNode root) {

        if (root==null) return 0;
        return Math.max(TreeDepth(root.left)+1,TreeDepth(root.right)+1);
    }
}
