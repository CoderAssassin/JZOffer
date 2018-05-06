/**
 * @author aliyang
 * @date 18-5-6 下午7:25
 * 树的子结构：我的解法，写的比较烂，写了贼久
 * 思路：先从root1中找出和root2的根相同的节点，然后判断root1中子节点的子结构是否和root2的结构一样，
 * 主要用了两个递归
 */
public class T_17 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if (root2==null)
            return false;

        return traverse(root1,root2);


    }

    private boolean traverse(TreeNode root1,TreeNode root2){

        if (root1==null||root2==null)
            return false;

        if (root1.val==root2.val){//如果某个节点和root2的根相同，那么判断root1中子结构是否存在
            if (judge(root1,root2)==true)
                return true;
        }

//        递归左右子树遍历
        if (traverse(root1.left,root2)==true)
            return true;
        else if (traverse(root1.right,root2)==true)
            return true;


        return false;
    }

//    判断两个子结构是否一样
    private boolean judge(TreeNode root1,TreeNode root2){

//        排除节点为root的情形
        if (root1==null&&root2==null)
            return true;

//        当root2已经遍历完，要提前停止，这种情况存在于root2在root1的中间的情况
        if (root2.left==null&&root2.right==null){
            if (root1.val==root2.val)
                return true;
            else return false;
        }

//        节点的孩子节点若不符合，提前判断
        if ((root1.left==null&&root2.left!=null)||
                (root1.left!=null&&root2.left==null)||
                (root1.right==null&&root2.right!=null)||
                (root1.right!=null&&root2.right==null))
            return false;

//        若两个节点的值相等，那么继续往下递归遍历
        if (root1.val==root2.val){
            if (judge(root1.left,root2.left)==true&&judge(root1.right,root2.right)==true)
                return true;
            else return false;
        }else return false;
    }

    public static void main(String[] args){
        T_17 t=new T_17();
        TreeNode root1=new TreeNode(8);
        TreeNode real_root1=root1;
        root1.left=new TreeNode(8);
        root1=root1.left;
        root1.left=new TreeNode(9);
        root1=root1.left;
        root1.left=new TreeNode(2);
        root1=root1.left;
        root1.left=new TreeNode(5);

        TreeNode root2=new TreeNode(8);
        TreeNode real_root2=root2;
        root2.left=new TreeNode(9);
        root2=root2.left;
        root2.left=new TreeNode(2);


        System.out.println(t.HasSubtree(real_root1,real_root2));


    }
}
