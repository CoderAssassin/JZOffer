/**
 * @Author:Aliyang
 * @Data: Created in 下午4:45 18-6-25
 * 数值的整数次方：二刷
 * 思路：二次幂
 **/
public class T12_again {

    public double Power(double base, int exponent) {

        double res=1;
        boolean negtive=false;
        if (exponent<0){
            negtive=true;
            exponent=-exponent;
        }

        while (exponent!=0){
            while ((exponent&1)!=1){//找到指数为1的位置
                exponent>>=1;
                base*=base;//更新基数
            }
            res*=base;//结果乘上基数
            exponent>>=1;
            base*=base;
        }
        return negtive?1/res:res;
    }

    public static void main(String[] args){
        T12_again t=new T12_again();
        System.out.println(t.Power(2,-5));
    }
}
