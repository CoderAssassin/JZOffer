/**
 * @Author:Aliyang
 * @Data: Created in 下午4:24 18-7-2
 * 平衡二叉树：二刷
 * 思路：递归
 **/
public class T39_again {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean flag=true;
    public boolean IsBalanced_Solution(TreeNode root) {

        if (root==null)
            return true;

        judge(root);
        return flag;

    }

    private int judge(TreeNode root){

        if (flag==false)
            return 0;
        if (root==null)
            return 0;
        int left=judge(root.left);
        int right=judge(root.right);
        if (Math.abs(left-right)>1)
            flag=false;
        return Math.max(judge(root.left)+1,judge(root.right)+1);
    }

    public static void main(String[] args){
        T39_again t=new T39_again();
        TreeNode root=new TreeNode(1);

    }
}
