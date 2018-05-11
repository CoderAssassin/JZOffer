
/**
 * @author aliyang
 * @date 18-5-11 下午2:10
 * 构建乘积数组：我的解法
 * 思路：用两个数组，C数组C[i]=A[0]*...*A[i],D[i]=A[i]*...*A[A.length()-1]，
 * 那么最后的结果（用A数组存），A[0]=D[1],A[A.length()-1]=C[A.length()-2]，其他
 * A[i]=C[i-1]*D[i+1]
 */
public class T_51 {

    public int[] multiply(int[] A) {

        int[] C=new int[A.length];//从头乘到尾
        int[] D=new int[A.length];//从尾乘到头

        C[0]=A[0];
        D[A.length-1]=A[A.length-1];

        for (int i=1,j=A.length-2;i<A.length;i++,j--){
            C[i]=A[i]*C[i-1];
            D[j]=A[j]*D[j+1];
        }

        A[0]=D[1];
        for (int i=1;i<A.length-1;i++)
            A[i]=C[i-1]*D[i+1];
        A[A.length-1]=C[A.length-2];

        return A;
    }

    public static void main(String[] args){
        T_51 t=new T_51();

        int[] a=new int[]{1,2,3,4,5,6};
        a=t.multiply(a);
        for (int i=0;i<a.length;i++)
            System.out.println(a[i]+" ");
    }
}
