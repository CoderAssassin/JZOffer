/**
 * @author aliyang
 * @date 18-5-10 下午8:56
 * 扑克牌顺子：别人解法
 * 思路：满足两个条件
 * 1.除0外没有重复的数
 * 2.max-min<5
 */
public class T_45_1 {

    public boolean isContinuous(int [] numbers) {
        if(numbers.length != 5) return false;
        int min = 14;
        int max = -1;
        int flag = 0;
        for(int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if(number < 0 || number > 13) return false;
            if(number == 0) continue;
            if(((flag >> number) & 1) == 1) return false;
            flag |= (1 << number);
            if(number > max) max = number;
            if(number < min) min = number;
            if(max - min >= 5) return false;
        }
        return true;
    }
}
