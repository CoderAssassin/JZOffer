/**
 * @author aliyang
 * @date 18-5-5 下午5:25
 * 二进制中1的个数：我的解法
 * 思路：分成正数和负数，负数的话模拟反码的过程
 * 注意：这题整数是32位！！！
 */
public class T_11 {

    public int NumberOf1(int n) {

        int count=0;

        if (n>=0){
            while (n/2!=0){
                if (n%2==1)
                    count++;
                n/=2;
            }
            if (n==1)
                count++;
        }else {
            n=Math.abs(n);
            int[] res=new int[32];//记录码的每一位，这里是倒过来的
            int index=0;//原码的位数

//            计算原码
            while (n/2!=0){
                if (n%2==1)
                    res[index++]=1;
                else res[index++]=0;
                n/=2;
            }
            if (n==1)
                res[index++]=1;
            else res[index++]=0;

//            求反码
            for (int i=0;i<32;i++){
                if (res[i]==0)
                    res[i]=1;
                else res[i]=0;
            }

//            取反后加1
            int addNum=1;//进位
            for (int i=0;i<32;i++){
                if (res[i]+addNum==2){
                    res[i]=0;
                    addNum=1;
                }
                else{
                    if (addNum==1){
                        res[i]+=addNum;
//                        count++;
                        addNum=0;
                    }else{
                        addNum=0;
                        break;
                    }
                }
            }

//            计算1的个数
            for (int i=0;i<32;i++)
                if (res[i]==1)
                    count++;

            if (res[31]==0)
                count++;

//            如果正好是8位的整数倍
//            if (index%8==0){
//                if (addNum==1)
//                    count++;
//            }else {
//                if (addNum==1)
//                    count++;
//                else count+=8-index%8;
//            }
        }
        return count;
    }

    public static void main(String[] args){
        T_11 t=new T_11();
        System.out.println(t.NumberOf1(-2147483648));

    }
}
