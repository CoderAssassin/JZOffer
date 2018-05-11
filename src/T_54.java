import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author aliyang
 * @date 18-5-11 下午9:43
 * 字符流中第一个不重复的字符：我的解法
 * 思路：用个set集合保存到现在为止只出现一次的字符
 * 别人优化：我的set会有多次插入删除，别人用一个128位整形数组保存出现次数，然后只有第一次遇到字符的
 * 时候才插入队列
 */
public class T_54 {

    Set<Character> set=new LinkedHashSet<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (set.contains(ch))
            set.remove(ch);
        else set.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if (set.size()==0)
            return '#';
        for (Character c:set)
            return c;
        return '#';
    }

}
