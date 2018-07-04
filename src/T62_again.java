/**
 * @Author:Aliyang
 * @Data: Created in 下午3:30 18-7-4
 * 二叉搜索树的第k个节点：二刷
 **/
public class T62_again {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int index=0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        return find(pRoot,k);
    }

    private TreeNode find(TreeNode pRoot,int k){

        if (pRoot==null)
            return null;

        TreeNode res=null;
        if ((res=find(pRoot.left,k))!=null)
            return res;
        index++;
        if (index==k)
            return pRoot;
        if ((res=find(pRoot.right,k))!=null)
            return res;
        return null;
    }

    public static void main(String[] args){
        T62_again t=new T62_again();
        TreeNode tree=new TreeNode(5);
        TreeNode real_tree=tree;

        tree.left=new TreeNode(3);
        tree.right=new TreeNode(7);
        TreeNode left=tree.left;
        TreeNode right=tree.right;
        left.left=new TreeNode(2);
        left.right=new TreeNode(4);
        right.left=new TreeNode(6);
        right.right=new TreeNode(8);

        TreeNode res=t.KthNode(real_tree,4);
        System.out.println(res.val);
    }
}
