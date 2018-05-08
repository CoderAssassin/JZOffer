import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-5-8 下午7:07
 * 丑数：我的解法超时，参考别人的解法
 * 别人解法：用已知的丑数生成新的丑数
 * 丑数的定义是1或者因子只有2 3 5，可推出丑数=丑数*丑数，假定丑数有序序列为：a1,a2,a3.......an
 * 所以可以将以上序列（a1除外）可以分成3类，必定满足：
 * 包含2的有序丑数序列：2*a1, 2*a2, 2*a3 .....
 * 包含3的有序丑数序列：3*a1, 3*a2, 3*a3 .....
 * 包含5的有序丑数序列：5*a1, 5*a2, 5*a3 .....
 * 以上3个序列的个数总数和为n个，而且已知a1 = 1了，将以上三个序列合并成一个有序序列即可 
 * 程序中t2,t3,t5实际就是合并过程中三个序列中带排序的字段索引
 */
public class T_33 {

//    public int GetUglyNumber_Solution(int index) {
//        if (index==1)
//            return 1;
//        int count=1;
//
//        int num=2;
//        int res=1;
//        while (count<index){
//
//            int tmp=num;
//            while (tmp%30==0)
//                tmp/=30;
//            while (tmp%15==0)
//                tmp/=15;
//            while (tmp%10==0)
//                tmp/=10;
//            while (tmp%5==0)
//                tmp/=5;
//            while (tmp%3==0)
//                tmp/=3;
//            while (tmp%2==0)
//                tmp/=2;
//
//            if (tmp==1){
//                res=num;
//                count++;
//            }
//            num++;
//        }
//        return res;
//    }

    public int GetUglyNumber_Solution(int index) {

        if (index<7) return index;
        ArrayList<Integer> res=new ArrayList<>();
        res.add(1);
        int t2=0,t3=0,t5=0,i;//表示2，3和5包含的次数
        for (i=1;i<index;i++){
            res.add(Math.min(res.get(t2)*2,Math.min(res.get(t3)*3,res.get(t5)*5)));//括号里边生成的是索引，取小的索引
            if (res.get(i)==res.get(t2)*2) t2++;
            if (res.get(i)==res.get(t3)*3) t3++;
            if (res.get(i)==res.get(t5)*5) t5++;
        }

        return res.get(index-1);
    }

    public static void main(String[] args){
        T_33 t=new T_33();
        System.out.println(t.GetUglyNumber_Solution(1000));

    }
}
