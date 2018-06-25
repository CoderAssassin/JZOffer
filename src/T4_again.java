/**
 * @Author:Aliyang
 * @Data: Created in 下午4:11 18-6-25
 * 重建二叉树：二刷
 * 思路：递归建立左右子树
 **/
public class T4_again {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    int count=0;//计数已经多少个节点建立了
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        if (pre.length!=in.length||pre.length==0||in.length==0)
            return null;
        return build(pre,in,0,0,in.length-1);
    }

    private TreeNode build(int[] pre,int[] in,int start_pre,int start_in,int end_in){

        if (start_pre>pre.length-1||start_in>end_in)
            return null;

        TreeNode root=new TreeNode(pre[start_pre]);
        count++;

        int root_val=pre[start_pre];
        for (int i=start_in;i<=end_in;i++){
            if (in[i]==root_val){
                root.left=build(pre,in,count,start_in,i-1);
                root.right=build(pre,in,count,i+1,end_in);
             break;
            }
        }
        return root;
    }

    public static void main(String[] args){
        T4_again t=new T4_again();
        int[] pre={1,2,3,4,5,6,7};
        int[] in={3,2,4,1,6,5,7};
        TreeNode res=t.reConstructBinaryTree(pre,in);
        System.out.println(1);
    }

}
