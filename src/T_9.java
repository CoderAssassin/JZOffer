/**
 * @author aliyang
 * @date 18-5-5 下午4:59
 * 变态跳台阶:我的解法
 * 思路：T_8来个for把前面所有数加起来
 */
public class T_9 {

    public int JumpFloorII(int target) {
        int[] dp=new int[100];

        dp[0]=1;
        dp[1]=1;

        for (int i=2;i<=target;i++){
            for (int j=1;j<=target&&i-j>=0;j++){
                dp[i]+=dp[i-j];
            }
        }
        return dp[target];
    }

    public static void main(String[] args){
        T_9 t=new T_9();
        System.out.println(t.JumpFloorII(4));

    }
}
