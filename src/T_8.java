/**
 * @author aliyang
 * @date 18-5-5 下午4:30
 * 跳台阶:我的解法,类似斐波那契数列
 * 思路：要不跳1阶要不跳2阶，跳1阶的话前边那一阶怎么跳都成，那就是dp[i-1][0]+dp[i-1][1]，
 * 跳两阶的话必须是前边那一阶跟着这一阶一起跳两阶，那就是dp[i-2][0]+dp[i-2][1]
 */
public class T_8 {

    public int JumpFloor(int target) {
        int[]dp=new int[100];//一维表示跳多少级台阶，二维表示跳一阶还是跳两阶，值表示跳法

        dp[0]=1;
        dp[1]=1;

        for (int i=2;i<=target;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[target];
    }

    public static void main(String[] args){
        T_8 t=new T_8();
        System.out.println(t.JumpFloor(5));

    }
}
