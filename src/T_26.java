/**
 * @author aliyang
 * @date 18-5-7 下午9:09
 * 二叉搜索树与双向链表：我的解法
 * 思路：根节点的left是左子树的最右下角节点，根节点的right是右子树的最左下角节点；
 * 递归，因为前面子树已经转换成链表，根的left指向的是左子树的right为null的节点，根的right
 * 指向的是右子树的left为null的节点
 */
public class T_26 {

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

    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree==null)
            return null;

        pRootOfTree=trans(pRootOfTree);
//        找到链表的头
        while (pRootOfTree.left!=null)
            pRootOfTree=pRootOfTree.left;

        return pRootOfTree;
    }

    private TreeNode trans(TreeNode pRootOfTree){

//        递归左右子树
        Convert(pRootOfTree.left);
        Convert(pRootOfTree.right);

        if (pRootOfTree.left!=null){
            TreeNode left=left_big(pRootOfTree.left);
            pRootOfTree.left=left;
            left.right=pRootOfTree;
        }
        if (pRootOfTree.right!=null){
            TreeNode right=right_small(pRootOfTree.right);
            pRootOfTree.right=right;
            right.left=pRootOfTree;
        }

        return pRootOfTree;
    }

//    找到左子树的最右下角节点
    private TreeNode left_big(TreeNode root){

        if (root==null)
            return null;
        while (root.right!=null)
            root=root.right;
        return root;
    }

//    找到右子树的最左下角节点
    private TreeNode right_small(TreeNode root){

        if (root==null)
            return null;
        while (root.left!=null)
            root=root.left;
        return root;
    }

    public static void main(String[] args){
        T_26 t=new T_26();
        TreeNode head=new TreeNode(8);
        TreeNode real_head=head;
        TreeNode left=new TreeNode(4);
        TreeNode right=new TreeNode(12);
        head.left=left;
        head.right=right;
        TreeNode left1=new TreeNode(3);
        TreeNode right1=new TreeNode(5);
        left.left=left1;
        left.right=right1;

        TreeNode res=t.Convert(real_head);
        System.out.println(res);


    }
}
