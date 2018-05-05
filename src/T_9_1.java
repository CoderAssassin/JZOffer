/**
 * @author aliyang
 * @date 18-5-5 下午5:12
 * 变态跳台阶：别人做法，推出递归公式用递归，我的做法用了数组打表
 * 思路：公式推导，target=0和target=1的时候f(target)=1，其他情况下f(target)=2*f(target-1)
 */
public class T_9_1 {

    public int JumpFloorII(int target) {
        if (target==0||target==1)
            return 1;
        else return 2*JumpFloorII(target-1);
    }
    public static void main(String[] args){

        T_9_1 t=new T_9_1();
        System.out.println(t.JumpFloorII(4));
    }
}
