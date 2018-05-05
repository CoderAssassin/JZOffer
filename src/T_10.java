/**
 * @author aliyang
 * @date 18-5-5 下午5:17
 * 矩形覆盖:我的解法
 * 思路：和T_8青蛙一样
 * 注意：0的时候是输出0
 */
public class T_10 {

    public int RectCover(int target) {

        if (target==0)
            return 0;
        else if (target==1)
            return 1;
        int[] dp=new int[100];
        dp[0]=1;
        dp[1]=1;


        for (int i=2;i<=target;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[target];
    }

    public static void main(String[] args){
        T_10 t=new T_10();
        System.out.println(t.RectCover(3));
    }

}
