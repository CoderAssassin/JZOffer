import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author aliyang
 * @date 18-5-12 下午6:53
 * 数据流中的中位数：别人解法
 * 思路：用一个大顶堆和一个小顶堆来分别保存数，大顶堆的数都比小顶堆小，小顶堆保存的数
 * 都比大顶堆大，那么最后的平均值只要从两个堆顶计算即可得到
 */
public class T_63_1 {

    PriorityQueue<Integer> p=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });//大顶堆
    PriorityQueue<Integer> q=new PriorityQueue<>();//小顶堆
    public void Insert(Integer num) {
        if (p.isEmpty()==true||num<=p.peek())
            p.add(num);
        else q.add(num);
        if (p.size()==q.size()+2){
            q.add(p.peek());
            p.poll();
        }
        if (p.size()+1==q.size()){
            p.add(q.peek());
            q.poll();
        }
    }

    public Double GetMedian() {
        return p.size()==q.size()?(p.peek()+q.peek())/2.0:p.peek()*1.0;
    }
}
