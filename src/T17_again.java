/**
 * @Author:Aliyang
 * @Data: Created in 下午5:11 18-6-25
 * 树的子结构：我的解法
 * 思路：递归，先递归root1，找到根相同的节点，然后判断两颗树是否相等，不等，那么继续递归找到下一个根相同的节点
 **/
public class T17_again {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1==null||root2==null)
            return false;

        return findAndJudge(root1,root2);
    }

    private boolean findAndJudge(TreeNode root1,TreeNode root2){

        if (root1==null)
            return false;

        if (root1.val==root2.val){
            if (judge(root1,root2))
                return true;
        }

        if (findAndJudge(root1.left,root2))
            return true;
        else{
            if (findAndJudge(root1.right,root2))
                return true;
        }
        return false;

    }
    private boolean judge(TreeNode root1,TreeNode root2){

        if (root2==null)
            return true;
        if (root1==null)
            return false;
        if (root1.val==root2.val){
            if (judge(root1.left,root2.left)&&judge(root1.right,root2.right))
                return true;
            else return false;
        }
        return false;
    }

    public static void main(String[] args){
        T17_again t=new T17_again();
        TreeNode root=new TreeNode(8);
        TreeNode realRoot=root;
        root.left=new TreeNode(8);
        root.right=new TreeNode(7);
        root=root.left;
        root.left=new TreeNode(9);
        root.right=new TreeNode(2);
        root=root.right;
        root.left=new TreeNode(4);
        root.right=new TreeNode(7);

        TreeNode root2=new TreeNode(8);
        root2.left=new TreeNode(9);
        root2.right=new TreeNode(2);

        System.out.println(t.HasSubtree(realRoot,root2));

    }
}
