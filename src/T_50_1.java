/**
 * @author aliyang
 * @date 18-5-11 下午2:10
 * 数组中重复的数字：别人解法
 * 思路：因为数字的范围是0到n-1之间，利用现有的数组，当一个数组被访问后，设置对应位上的数+n，之后再遇到
 * 相同的数，若发现对应位上的数已经大于等于n，直接返回
 */
public class T_50_1 {

    public boolean duplicate(int numbers[],int length,int [] duplication) {

        if (length==0)
            return false;

        for (int i=0;i<length;i++){
            int index=numbers[i];
            if (index>=length)
                index-=length;
            if (numbers[index]>=length){
                duplication[0]=index;
                return true;
            }
            numbers[index]=numbers[index]+length;
        }
        return false;
    }
}
