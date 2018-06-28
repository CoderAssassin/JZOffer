/**
 * @Author:Aliyang
 * @Data: Created in 下午3:36 18-6-28
 * 连续子数组的最大和：二刷，最优解没想出来
 * 思路：动态规划，F(i)=max(F(i-1)+array[i],array[i])
 **/
public class T30_again {

    public int FindGreatestSumOfSubArray(int[] array) {

        int max=array[0];
        int res=array[0];
        for (int i=1;i<array.length;i++){
            max=Math.max(max+array[i],array[i]);
            res=Math.max(res,max);
        }
        return res;
    }

    public static void main(String[] args){
        T30_again t=new T30_again();
        int[] array={6,-3,-2,7,-15,1,2,2};
        System.out.println(t.FindGreatestSumOfSubArray(array));
    }
}
