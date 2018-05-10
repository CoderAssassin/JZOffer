import java.util.Arrays;

/**
 * @author aliyang
 * @date 18-5-10 下午4:03
 * 扑克牌顺子：我的解法
 * 思路：排序，第一个不是0的数和最后一个数之间的差+1为连续的位数，然后减去现有的不为0的个数得到的差是还需要的数的个数，
 * 然后和0的个数比较，0的个数需要比需要的数字个数多
 */
public class T_45 {

    public boolean isContinuous(int [] numbers) {

        if (numbers.length==0)
            return false;

        Arrays.sort(numbers);

        int zeroNum=0;
        int i=0;
        for (;i<numbers.length;i++){
            if (numbers[i]==0)
                zeroNum++;
            else break;
        }

        int remain=numbers[numbers.length-1]-numbers[i]+1-(numbers.length-i);
        if (remain<0)
            return false;
        if (zeroNum>=remain)
            return true;
        else return false;
    }

    public static void main(String[] args){
        T_45 t=new T_45();
        int[] a=new int[]{1,0,0,1,0};
        System.out.println(t.isContinuous(a));

    }
}
