/**
 * @Author:Aliyang
 * @Data: Created in 下午6:52 18-7-2
 * 孩子们的游戏(圆圈中最后剩下的数)：二刷
 **/
public class T46_again {

    public int LastRemaining_Solution(int n, int m) {
        if (n<=0||m<=0)
            return -1;

        int last=0;
        for (int i=2;i<=n;i++){
            last=(last+m)%i;
        }
        return last;
    }
}
