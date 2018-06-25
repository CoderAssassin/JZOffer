import java.util.ArrayList;

/**
 * @Author:Aliyang
 * @Data: Created in 下午7:34 18-6-25
 * 二叉树中和为某一值的路径：二刷
 * 思路：递归
 **/
public class T24_again {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        res=new ArrayList<>();
        if (root==null)
            return res;

        find(root,target,new ArrayList<Integer>(),0);
        return res;
    }

    private void find(TreeNode root,int target,ArrayList<Integer> cur,int sum){

        if (root==null)
            return;

        sum+=root.val;
        cur.add(root.val);
        if (sum==target&&root.left==null&&root.right==null){
            ArrayList<Integer> tmp=new ArrayList<>(cur);
            res.add(tmp);
            cur.remove(cur.size()-1);
            return;
        }
        if (sum>target){
            cur.remove(cur.size()-1);
            return;
        }

        find(root.left,target,cur,sum);
        find(root.right,target,cur,sum);
        cur.remove(cur.size()-1);
    }

    public static void main(String[] args){
        T24_again t=new T24_again();
        TreeNode root=new TreeNode(1);
        TreeNode realRoot=root;
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        ArrayList<ArrayList<Integer>> res=t.FindPath(root,3);
        for (ArrayList<Integer> cur:res){
            for (Integer a:cur){
                System.out.print(a+",");
            }
            System.out.println();
        }
    }
}
