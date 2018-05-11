import java.util.LinkedList;
import java.util.Queue;

/**
 * @author aliyang
 * @date 18-5-11 下午10:01
 * 字符流中第一个不重复的字符：别人解法
 * 思路：
 * 时间复杂度O（1），空间复杂度O（n）
 *         1、用一个128大小的数组统计每个字符出现的次数
 *         2、用一个队列，如果第一次遇到ch字符，则插入队列；其他情况不在插入
 *         3、求解第一个出现的字符，判断队首元素是否只出现一次，如果是直接返回，否则删除继续第3步骤
 */
public class T_54_1 {

    Queue data=new LinkedList();
    short[] cnt=new short[128];
    int i=0;

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        cnt[ch-'\0']++;
        if (cnt[ch-'\0']==1)
            data.offer(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        while (!data.isEmpty()&&cnt[(int)data.peek()]>=2)
            data.poll();
        if (data.isEmpty())
            return '#';
        return (char)data.peek();
    }
}
