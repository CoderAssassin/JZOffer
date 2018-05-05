import java.util.Collections;

/**
 * @author aliyang
 * @date 18-5-5 下午2:26
 * 重建二叉树：自己写的解法
 * 解题思路：用递归的思想，从前序序列中找到第一个中序中的数字，这个数字是根，
 * 将中序序列分成两个数组，一个是属于左子树，一个是属于右子树，然后分别以这两个数组为
 * 中序输入，递归遍历
 * 时间和空间复杂度都比较高
 */
public class T_4 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "("+val+","+left+","+right+")";
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        if (in.length==0)
            return null;

        int preLength=pre.length;
        int inLength=in.length;

        int root=-1;

//        拿到中序数组中的数在前序数组中的第一个位置
        int j=0;
        root:
        for (int i=0;i<preLength;i++){
            for (j=0;j<inLength;j++){
                if (pre[i]==in[j]){
                    root=pre[i];
                    break root;
                }
            }
        }
        int indexOfRoot=j;
        TreeNode tree=new TreeNode(root);

        if (indexOfRoot!=-1&&indexOfRoot!=inLength-1){//如果中序数组可以划分成两个数组
            int [] leftIn=new int[indexOfRoot];
            int [] rightIn=new int[inLength-indexOfRoot-1];
            for (int i=0;i<indexOfRoot;i++)
                leftIn[i]=in[i];
            for (int i=indexOfRoot+1;i<inLength;i++)
                rightIn[i-indexOfRoot-1]=in[i];

            tree.left=reConstructBinaryTree(pre,leftIn);
            tree.right=reConstructBinaryTree(pre,rightIn);
        }else if (indexOfRoot==0){//如果中序数组只能划分成一个右数组
            tree.left=null;
            int[] rightIn=new int[inLength-1];
            for (int i=1;i<inLength;i++)
                rightIn[i-1]=in[i];
            tree.right=reConstructBinaryTree(pre,rightIn);
        }else if (indexOfRoot==inLength-1){//如果中序数组只能划分成一个左数组
            tree.right=null;
            int[] leftIn=new int[inLength-1];
            for (int i=0;i<inLength-1;i++)
                leftIn[i]=in[i];
            tree.left=reConstructBinaryTree(pre,leftIn);
        }

        return tree;
    }

    public static void main(String[] args){

        T_4 t=new T_4();
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        TreeNode tree=t.reConstructBinaryTree(pre,in);
        System.out.println(tree.toString());

    }
}
