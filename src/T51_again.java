/**
 * @Author:Aliyang
 * @Data: Created in 下午1:35 18-7-3
 * 构建乘积数组：二刷
 * 思路：先构造数组b都只有从缺少的数开始往前的所有的数，然后把后边的数依次乘进来，遍历两次数组，O(2n)
 **/
public class T51_again {

//    思路一：先构造数组b都只有从缺少的数开始往前的所有的数，然后把后边的数依次乘进来，遍历两次数组，O(2n)；其实就是矩阵的上下三角连乘
    public int[] multiply(int[] A) {

        int[] b=new int[A.length];
        b[0]=1;
        for (int i=1;i<A.length;i++)
            b[i]=b[i-1]*A[i-1];
        int tmp=1;
        for (int i=A.length-1;i>=0;i--){
            b[i]=b[i]*tmp;
            tmp=tmp*A[i];
        }
        return b;
    }

}
