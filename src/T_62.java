import java.util.ArrayList;
import java.util.Stack;

/**
 * @author aliyang
 * @date 18-5-12 下午3:50
 * 二叉搜索树的第k个节点：别人解法
 * 思路：利用中序遍历，分为递归版和非递归版
 */
public class T_62 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


//    思路一：递归版本
    int index=0;//计数
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot!=null){
            TreeNode node=KthNode(pRoot.left,k);
            if (node!=null)
                return node;
            index++;
            if (index==k)
                return pRoot;
            node=KthNode(pRoot.right,k);
            if (node!=null)
                return node;
        }
        return null;
    }

//    思路二：非递归中序遍历
//    TreeNode KthNode(TreeNode root, int k){
//        if(root==null||k==0)
//            return null;
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        int count = 0;
//        TreeNode node = root;
//        do{
//            if(node!=null){
//                stack.push(node);
//                node = node.left;
//            }else{
//                node = stack.pop();
//                count++;
//                if(count==k)
//                    return node;
//                node = node.right;
//            }
//        }while(node!=null||!stack.isEmpty());
//        return null;
//    }



    public static void main(String[] args){
        T_62 t=new T_62();
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

        TreeNode res=t.KthNode(real_tree,3);
        System.out.println(res.val);

    }
}
