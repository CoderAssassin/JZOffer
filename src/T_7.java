/**
 * @author aliyang
 * @date 18-5-5 下午4:23
 * 斐波那契数列:我的解法
 * 注意：0也是输入沃日
 */
public class T_7 {

//    第一种尝试，用递归，栈直接超了
//    public int Fibonacci(int n) {
//        if (n==1||n==2)
//            return 1;
//        else return Fibonacci(n-2)+Fibonacci(n-1);
//    }

//    栈超了之后用第二种方法，数组打表
    public int Fibonacci(int n) {
        if (n==0)
            return 0;
        if (n==1||n==2)
            return 1;
        int[] Fi=new int[39];
        Fi[0]=1;
        Fi[1]=1;
        for (int i=2;i<n;i++)
            Fi[i]=Fi[i-2]+Fi[i-1];
        return Fi[n-1];
    }

    public static void main(String[] args){
        T_7 t=new T_7();
        System.out.println(t.Fibonacci(39));

    }
}
