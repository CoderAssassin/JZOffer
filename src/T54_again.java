import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:18 18-7-3
 * 字符流中第一个不重复的字符：二刷
 **/
public class T54_again {

    //Insert one char from stringstream
    Queue<Character> first=new LinkedList<>();
    int[] chs=new int[128];
    public void Insert(char ch)
    {
        if (chs[ch-'\0']==0)
            first.offer(ch);
        chs[ch-'\0']++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        while (!first.isEmpty()&&chs[(int)first.peek()]>=2)
            first.poll();
        if (!first.isEmpty())
            return (char)first.peek();
        return '#';
    }
}
