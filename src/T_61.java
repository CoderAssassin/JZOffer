import java.util.LinkedList;

/**
 * @author aliyang
 * @date 18-5-12 下午2:24
 * 序列化二叉树：别人解法
 * 思路：
 * 根据前序遍历规则完成序列化与反序列化。所谓序列化指的是遍历二叉树为字符串；所谓反序列化指的是依据字符串重新构造成二叉树。
 *     依据前序遍历序列来序列化二叉树，因为前序遍历序列是从根结点开始的。当在遍历二叉树时碰到Null指针时，这些Null指针被序列化为一个特殊的字符“#”。
 *     另外，结点之间的数值用逗号隔开
 */
public class T_61 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int index=-1;//计数变量
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        index++;
        String[] strr = str.split(",");
        TreeNode node = null;
        if(!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

    public static void main(String[] args){
        T_61 t=new T_61();
        TreeNode tree=new TreeNode(8);
        TreeNode real_tree=tree;

        tree.left=new TreeNode(6);
        tree.right=new TreeNode(10);
        TreeNode left=tree.left;
        TreeNode right=tree.right;
        left.left=new TreeNode(5);
        left.right=new TreeNode(7);
        right.left=new TreeNode(9);
        right.right=new TreeNode(11);

        String res=t.Serialize(real_tree);
        System.out.println(res);

        TreeNode root=t.Deserialize(res);
        System.out.println(root);
    }
}
