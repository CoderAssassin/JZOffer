/**
 * @author aliyang
 * @date 18-5-8 下午4:08
 * 整数中1出现的次数(从1到n整数中1出现的次数)：我的解法
 * 思路：暴力，遍历每个数，每个数每一位都判断一下
 */
public class T_31 {

    public int NumberOf1Between1AndN_Solution(int n) {

        int count=0;
        for (int i=1;i<=n;i++){
            int tmp=i;
            while (tmp/10!=0){
                int remainder=tmp%10;
                tmp=tmp/10;
                if (remainder==1)
                    count++;
            }
            if (tmp==1)
                count++;
        }
        return count;
    }

    public static void main(String[] args){
        T_31 t=new T_31();
        System.out.println(t.NumberOf1Between1AndN_Solution(13));
    }
}
