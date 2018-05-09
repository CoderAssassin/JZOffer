/**
 * @author aliyang
 * @date 18-5-9 下午7:40
 * 数组中只出现一次的数字：别人解法
 * 思路：位运算，两个相同数字异或=0，一个数和0异或还是它本身
 * 问题一：如果数组中其他数字出现两次，只有一个数字出现一次。解法：从头到尾异或，最后的结果就是
 * 问题二：如果数组中有两个数字出现一次。解法：先从头到尾异或，最后的结果是两个出现一次的数字的异或结果，
 * 取最右边为1的位数，然后以该位为1为一组，为0为一组，分别和所有数进行异或计算，得到的结果为两个出现一次的数字
 * 问题三：如果其他数字出现三次，只有一个数字出现两次。解法：计算每一位为1的数的个数，然后统计所有位对3取余如果不是
 * 0的话，那么最后结果的该位为1
 */
public class T_40_1 {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        if(array == null || array.length <= 1){
            num1[0] = num2[0] = 0;
            return;
        }
        int len = array.length, index = 0, sum = 0;
        for(int i = 0; i < len; i++){
            sum ^= array[i];
        }
        for(index = 0; index < 32; index++){
            if((sum & (1 << index)) != 0) break;
        }
        for(int i = 0; i < len; i++){
            if((array[i] & (1 << index))!=0){
                num2[0] ^= array[i];
            }else{
                num1[0] ^= array[i];
            }
        }
    }
}
