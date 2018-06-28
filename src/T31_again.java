/**
 * @Author:Aliyang
 * @Data: Created in 下午4:27 18-6-28
 * 整数中1出现的次数：二刷，还是没有刷出来
 * 思路：看老的思路
 **/
public class T31_again {

    public int NumberOf1Between1AndN_Solution(int n) {
        int res=0;
        int i=1;
        for (;i<=n;i*=10){
            int a=n/i;
            int b=n%i;
            res+=(a+8)/10*i+(a%10==1?b+1:0);
        }
        return res;
    }
}
