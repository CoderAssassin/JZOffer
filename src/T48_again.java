/**
 * @Author:Aliyang
 * @Data: Created in 下午7:56 18-7-2
 * 不用加减乘除做加法：二刷
 **/
public class T48_again {

    public int Add(int num1,int num2) {

        if (num1==0)
            return num2;
        if (num2==0)
            return num1;

        int tmp=0,tmp1=0;//进位和不进位
        do {
            tmp=(num1&num2)<<1;//判断进位是否有
            tmp1=num1^num2;//不进位的位
            num1=tmp;
            num2=tmp1;
        }while (tmp!=0);

        return num2;
    }

    public static void main(String[] args){
        T48_again t=new T48_again();
        System.out.println(t.Add(3,5));
    }
}
