/**
 * @author aliyang
 * @date 18-5-10 下午10:18
 * 求1+2+3+...+n：我的解法
 * 思路：递归，用&&限制递归前提
 */
public class T_47 {


    public int Sum_Solution(int n) {
        int res=n;
        boolean flag=res>0&&(res+=Sum_Solution(n-1))>0;
        return res;
    }

    public static void main(String[] args){
        T_47 t=new T_47();
        System.out.println(t.Sum_Solution(100));

    }
}
