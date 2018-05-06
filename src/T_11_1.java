/**
 * @author aliyang
 * @date 18-5-6 下午2:40
 * 二进制中1的个数:别人解法,很巧妙
 * 思路：把一个整数减去1，那么二进制位最右边的一个1变成了0，这个1右边的所有的0都变成了1（如果有的话），
 * 如果把这个数和原来的二进制数与一下，那么原来的最右边的1和往右都变成了0，有多少个1就做多少次这样的减一
 * 运算，最后就是1的个数。另外，只要数大于0，说明至少由一个1。因为与运算在计算机里本来就是二进制的运算，且
 * 计算机中的二进制是用补码表示的，所以同样操作可行。
 */
public class T_11_1 {

    public int NumberOf1(int n) {
        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args){
        T_11_1 t=new T_11_1();
        System.out.println(t.NumberOf1(-1));
    }
}
