/**
 * @author aliyang
 * @date 18-5-12 上午8:37
 * 二叉树的下一个节点：我的解法
 * 思路：
 * 若当前节点是左孩子节点：那么下一个节点是根节点
 * 若当前节点是根节点或者右孩子节点：那么下一个节点是右子树的最左孩子节点或者指向根节点(当为根的左子树的最右节点的时候)
 */
public class T_57 {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode==null)
            return null;

        if (pNode.next!=null&&pNode==pNode.next.left){//若是左孩子节点
            if (pNode.right==null)
                return pNode.next;
            else return getLeft(pNode.right);
        }
        if (pNode.next==null||pNode==pNode.next.right){//为根节点或者右孩子节点
            if (pNode.right==null&&pNode.next!=null){//下一个是根节点或者null
                TreeLinkNode pre=pNode;
                pNode=pNode.next;
                while (pNode.next!=null){
                    pre=pNode;
                    pNode=pNode.next;
                }
                if (pre==pNode.left)
                    return pNode;
                else return null;
            }
            else {
                return getLeft(pNode.right);
            }
        }
        return pNode;
    }

//    获取最左节点
    private TreeLinkNode getLeft(TreeLinkNode pNode){
        if (pNode==null)
            return null;
        while (pNode.left!=null)
            pNode=pNode.left;
        return pNode;
    }

    public static void main(String[] args){
        T_57 t=new T_57();
        TreeLinkNode tree=new TreeLinkNode(1);
        TreeLinkNode real_tree=tree;
        tree.left=new TreeLinkNode(2);
        tree.left.next=tree;
        tree.right=new TreeLinkNode(3);
        tree.right.next=tree;
        tree=tree.left;
        tree.left=new TreeLinkNode(4);
        TreeLinkNode query=tree.left;
        tree.left.next=tree;
        tree.right=new TreeLinkNode(5);
        tree.right.next=tree;

        TreeLinkNode res=t.GetNext(real_tree);
        System.out.println(res.val);

    }

}
