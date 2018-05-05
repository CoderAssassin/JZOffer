/**
 * @author aliyang
 * @date 18-5-5 下午3:14
 * 重建二叉树：别人的解法,思路和我的基本一样，但是是从前序数组开始看，每次以前序数组第一个数为根，
 * 而我是以后续数组在前序数组出现的第一个数为根，比我的解法少了很多空间
 * 思想：前序中的某个数在中序出现的位置若是i，那么i之前的所有数一定是前序的i所在的位置接下来的几个数
 */
public class T_4_1 {

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
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }
            return root;
    }
}
