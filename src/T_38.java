/**
 * @author aliyang
 * @date 18-5-9 下午3:52
 * 二叉树的深度：我的解法
 * 思路：设置一个全局变量，递归遍历左右子树，回溯的时候深度要减一，实时更新最大深度的值
 */
public class T_38 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    int res=0;
    public int TreeDepth(TreeNode root) {

        res=0;
        if (root==null)
            return 0;

        depth(root,1);
        return res;

    }

    private int depth(TreeNode root,int depth){

        if (root==null)
            return depth-1;

        depth=depth(root.left,depth+1);
        depth=depth(root.right,depth+1);

        if (res<depth)
            res=depth;
        return depth-1;
    }

    public static void main(String[] args){
        T_38 t=new T_38();

        TreeNode root1=new TreeNode(1);
        TreeNode real_root1=root1;
        root1.left=new TreeNode(2);
        root1.right=new TreeNode(3);

        t.TreeDepth(real_root1);
        System.out.println(t.res);

    }

}
