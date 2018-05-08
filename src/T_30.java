/**
 * @author aliyang
 * @date 18-5-8 下午1:55
 * 连续子数组的最大和：我的解法
 * 思路：从左到右搜索，计算累加和，若累加和小于0，那么说明负数部分和正数加起来更小，即
 * 负数把正数全都减没了，那么负数部分两边的正数肯定是不能相加的。这里由个特殊情况，全都是负数，需要特殊处理下
 */
public class T_30 {

    public int FindGreatestSumOfSubArray(int[] array) {

        if (array.length==0)
            return 0;

        int sum=0;//连续非负数的和
        int max=Integer.MIN_VALUE;
        for (int i=0;i<array.length;i++){
            if (sum+array[i]<0){//当和小于0的时候，那么重置sum
                sum=0;
                if (max<array[i])//处理纯负数的情况
                    max=array[i];
                continue;
            }
            sum+=array[i];
            if (max<sum)
                max=sum;
        }
        return max;
    }

    public static void main(String[] args){
        T_30 t=new T_30();
        int[] a=new int[]{1,-2,3,10,-4,7,2,-5};
        System.out.println(t.FindGreatestSumOfSubArray(a));

    }
}
