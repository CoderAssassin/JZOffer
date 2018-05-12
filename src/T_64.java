import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author aliyang
 * @date 18-5-12 下午7:08
 * 滑动窗口的最大值：我的解法
 * 思路：用最大堆，每次把上一次的第一个数去掉，加入新的数，然后获取堆顶的数
 */
public class T_64 {

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if (num.length==0||size==0||size>num.length)
            return new ArrayList<>();

        ArrayList<Integer> res=new ArrayList<>();
        PriorityQueue<Integer> bigHeap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });//大顶堆
        int i=0;
        for (i=0;i<size;i++)
            bigHeap.add(num[i]);
        res.add(bigHeap.peek());
        if (size>=num.length)
            return res;

        int first=0;//前一个窗口的第一个位置
        for (;i<num.length;i++){
            bigHeap.remove(num[first++]);
            bigHeap.add(num[i]);
            res.add(bigHeap.peek());
        }
        return res;
    }

    public static void main(String[] args){
        T_64 t=new T_64();
        int[] a=new int[]{2,3,4,2,6,2,5,1};
        ArrayList<Integer> res=t.maxInWindows(a,3);

        for (Integer i:res)
            System.out.println(i+" ");
    }
}
