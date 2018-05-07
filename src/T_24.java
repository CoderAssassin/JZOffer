import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-5-7 下午7:07
 * 二叉树中和为某一值的路径：ArrayList<ArrayList<Integer>>不知道怎么递归，参考别人解法
 * 思路：和我想的不一样，我以为整个ArrayList<ArrayList<Integer>>放进去递归，原来是一个一个列表递归，合格
 * 的再保存
 */
public class T_24 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null) return res;
        list.add(root.val);
        target-=root.val;
        if (target==0&&root.left==null&&root.right==null)//如果一条路线满足，那么加入结果列表
            res.add(new ArrayList<Integer>(list));//添加的必须是新的列表
        FindPath(root.left,target);//左路搜索
        FindPath(root.right,target);//右路搜索
        list.remove(list.size()-1);//要往上回溯一个节点，所以要删除当前搜的节点
        return res;
    }

}
