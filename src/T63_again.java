import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:47 18-7-4
 * 数据流中的中位数：二刷
 **/
public class T63_again {

    PriorityQueue<Integer> small=new PriorityQueue<>();//小顶堆
    PriorityQueue<Integer> big=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });//大顶堆
    public void Insert(Integer num) {

        if (big.isEmpty()||big.peek()>num)
            big.add(num);
        else small.add(num);

//        调整数量，大顶堆的数量大于等于小顶堆的数量
        if (big.size()==small.size()+2)//如果大顶堆比小顶堆多2个元素，调整成相等
            small.add(big.poll());
        if (big.size()+1==small.size())//如果大顶堆比小顶堆少1个元素，调整使得小顶堆小于大顶堆一个元素
            big.add(small.poll());
    }

    public Double GetMedian() {
        return big.size()==small.size()?(big.peek()+small.peek())/2.0:big.peek()*1.0;
    }

    public static void main(String[] args){
        T63_again t=new T63_again();
        int[] arr={5,2,3,4,1,6,7,0,8};
        for (Integer a:arr){
            t.Insert(a);
            System.out.println(t.GetMedian());
        }
    }
}
