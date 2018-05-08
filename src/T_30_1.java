/**
 * @author aliyang
 * @date 18-5-8 下午3:52
 * 连续子数组的最大和：别人解法
 * 思路：使用的动态规划，这个真没考虑到
 * F(i)=max(F(i-1)+array[i],array[i])表示以array[i]为末尾元素的子数组的和的最大值
 * 那么总的结果res=max(res,F(i))
 */
public class T_30_1 {

    public int FindGreatestSumOfSubArray(int[] array) {
        int res=array[0];//记录当前子数组的和的最大值
        int max=array[0];//包含array[i]的连续数组的最大值
        for (int i=1;i<array.length;i++){
            max=Math.max(max+array[i],array[i]);
            res=Math.max(max,res);
        }
        return res;
    }

}
