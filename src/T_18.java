/**
 * @author aliyang
 * @date 18-5-6 下午9:11
 * 二叉树的镜像：我的解法
 * 思路：还是递归
 */
public class T_18 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public void Mirror(TreeNode root) {
        reverse(root);
    }

//    倒转
    private TreeNode reverse(TreeNode root){

        if (root==null)
            return root;
        if (root.left==null&&root.right==null)
            return root;
        else {
            TreeNode tmp=reverse(root.right);
            root.right=reverse(root.left);
            root.left=tmp;
        }
        return root;
    }

    private void printTree(TreeNode root){

        if (root==null)
            return;

        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }


    public static void main(String[] args){
        T_18 t=new T_18();
        TreeNode root1=new TreeNode(8);
        TreeNode real_root1=root1;
        root1.left=new TreeNode(6);
        root1.right=new TreeNode(10);
        TreeNode root_left=root1.left;
        TreeNode root_right=root1.right;
        root_left.left=new TreeNode(5);
        root_left.right=new TreeNode(7);
        root_right.left=new TreeNode(9);
        root_right.right=new TreeNode(11);

        t.Mirror(real_root1);
        t.printTree(real_root1);
    }
}
