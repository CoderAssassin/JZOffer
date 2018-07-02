import java.util.ArrayList;

/**
 * @Author:Aliyang
 * @Data: Created in 下午1:53 18-7-2
 * 丑数：二刷
 * 思路：核心思想，丑数=丑数*丑数，除了1外，其他所有的数都是2,3,5的乘积
 **/
public class T33_again {

    public int GetUglyNumber_Solution(int index) {

        if (index<7)
            return index;

        ArrayList<Integer> list=new ArrayList<>(index);
        list.add(1);
        int t2=0,t3=0,t5=0,i;//t2,t3,t5分别为对应的2的几倍，3的几倍，5的几倍

        for (i=1;i<index;i++){
            list.add(Math.min(list.get(t2)*2,Math.min(list.get(t3)*3,list.get(t5)*5)));//取第t2个2，第t3个3和第t5个5中最小的一个
//            更新t2，t3，t5索引
            if (list.get(i)==list.get(t2)*2) t2++;
            if (list.get(i)==list.get(t3)*3) t3++;
            if (list.get(i)==list.get(t5)*5) t5++;
        }
        return list.get(index-1);
    }
}
