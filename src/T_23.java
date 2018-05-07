/**
 * @author aliyang
 * @date 18-5-7 下午4:17
 * 二叉搜索树的后序遍历序列：我的解法
 * 思路：后序遍历最后一个数是根节点，数组前面先是一些连续的比根节点小的数，然后是连续的比根节点大的数，递归
 */
public class T_23 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0)
            return false;
        return judge(sequence,0,sequence.length-1);
    }

    private boolean judge(int[] sequence,int start,int end){

        int root=sequence[end];

        int i=start;
        int mid=0;
//        找到左子树的右边的一个下标
        while (sequence[i]<root)
            i++;
        mid=i;
//        如果右子树有比root小的那就出错了
        for (;i<=end;i++)
            if (sequence[i]<root)
                return false;

        if (mid!=0){
            if (judge(sequence,start,mid-1)==false&&judge(sequence,mid,end-1)==false)
                return false;
        }else {
            if (end!=0)
                if (judge(sequence,mid,end-1)==false)
                    return false;
            else return true;
        }

        return true;
    }

    public static void main(String[] args){
        T_23 t=new T_23();
        int[] num=new int[]{5,6,9,10,7,1,11,8};
        System.out.println(t.VerifySquenceOfBST(num));
    }
}
