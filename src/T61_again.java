/**
 * @Author:Aliyang
 * @Data: Created in 下午2:46 18-7-4
 * 序列化二叉树：二刷
 **/
public class T61_again {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int index=-1;
    String Serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        if (root!=null){
            sb.append(root.val+",");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
        }else sb.append("#,");
        return sb.toString();
    }

    TreeNode Deserialize(String str) {

        index++;
        String[] strr=str.split(",");
        if (strr.length!=0&&!strr[index].equals("#")){
            TreeNode newNode=new TreeNode(Integer.valueOf(strr[index]));
            newNode.left=Deserialize(str);
            newNode.right=Deserialize(str);
            return newNode;
        }else return null;
    }


    public static void main(String[] args){
        T61_again t=new T61_again();
        TreeNode tree=new TreeNode(8);
        TreeNode real_tree=tree;

        tree.left=new TreeNode(6);
        tree.right=new TreeNode(10);
        TreeNode left=tree.left;
        TreeNode right=tree.right;
        left.left=new TreeNode(5);
        left.right=new TreeNode(7);
        right.left=new TreeNode(9);
//        right.right=new TreeNode(11);
        String searize=t.Serialize(real_tree);
        System.out.println(searize);

        TreeNode res=t.Deserialize(searize);
        System.out.println(1);
    }
}
