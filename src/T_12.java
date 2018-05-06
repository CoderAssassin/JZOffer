/**
 * @author aliyang
 * @date 18-5-6 下午2:53
 * 数值的整数次方：他人解法，很妙，这题我不会
 * 思路：首先将指数都先转换成正数，几个数的相乘，指数是相加的，将指数转换成二进制，比如13为1101，
 * 即1000+0100+0001，所以每次将指数与上1，若结果为1，那么相乘，并且每次将指数往右移动一位，底数
 * 也要相应地平方，原因是二进制前边一位是后边的两倍，也就是当指数为后边那一位的数的时候的两倍，那么对于底数
 * 来说就是乘方
 */
public class T_12 {

    public double Power(double base, int exponent){

        int n;
        double baseNum=base,res=1;

//        判断指数是不是正数
        if (exponent>0){
            n=exponent;
        }else if (exponent<0){
            if (base==0) throw new RuntimeException("分母为0");
            n=-exponent;
        }else {
            return 1;
        }

        while (n!=0){
            if ((n&1)==1){
                res=res*baseNum;
            }
            baseNum*=baseNum;//指数往右移动一位，那么下一次的底数就是平方了
            n>>=1;//指数向右移动一位
        }

        return exponent>=0?res:(1/res);
    }

    public static void main(String[] args){
        T_12 t=new T_12();
        System.out.println(t.Power(2.3,4));
    }
}
