import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-5-12 下午7:35
 * 滑动窗口的最大值：别人解法
 * 思路：
 * 用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
 * 1.判断当前最大值是否过期
 * 2.新增加的值从队尾开始比较，把所有比他小的值丢掉
 */
public class T_64_1 {

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0) return res;
        int begin;//窗口的最左边
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < num.length; i++){
            begin = i - size + 1;
            if(q.isEmpty())
                q.add(i);//加入下标
            else if(begin > q.peekFirst())//将比当前的索引小的删掉，去掉过期的
                q.pollFirst();

            while((!q.isEmpty()) && num[q.peekLast()] <= num[i])//将比当前的值小的都删掉
                q.pollLast();
            q.add(i);
            if(begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;
    }
}
