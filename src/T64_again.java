import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @Author:Aliyang
 * @Data: Created in 下午4:12 18-7-4
 * 滑动窗口的最大值：二刷
 **/
public class T64_again {

//    public ArrayList<Integer> maxInWindows(int [] num, int size)
//    {
//        ArrayList<Integer> res=new ArrayList<>();
//        if (num.length==0||size==0||size>num.length)
//            return res;
//        int max=Integer.MIN_VALUE,maxIndex=-1,sum=0,i=0;
//        for (;i<num.length&&i<size;i++){
//            if (num[i]>max){
//                max=num[i];
//                maxIndex=i;
//            }
//        }
//        res.add(max);
//
//        int first=0;//窗口的起始位置
//        for (;i<num.length;i++){
//            first++;
//            if (num[i]>=max){//如果新的数更大，直接标为新的数
//                max=num[i];
//                maxIndex=i;
//            }else {//如果最大的数过期了，那么重新选取
//                if (maxIndex<first){
//                    max=Integer.MIN_VALUE;
//                    for (int j=first;j<first+size;j++){
//                        if (num[j]>max){
//                            max=num[j];
//                            maxIndex=j;
//                        }
//                    }
//                }
//            }
//            res.add(max);
//        }
//        return res;
//    }

//    思路二：双端队列
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res=new ArrayList<>();
        if (size==0)
            return res;
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        int begin;
        for (int i=0;i<num.length;i++){
            begin=i-size+1;
            if (deque.isEmpty())
                deque.add(i);
            else if (deque.peekFirst()<begin)
                deque.pollFirst();

            while ((!deque.isEmpty())&&num[deque.peekLast()]<=num[i])
                deque.pollLast();

            deque.add(i);

            if (begin>=0)
                res.add(num[deque.peekFirst()]);
        }

        return res;
    }

    public static void main(String[] args){
        T64_again t=new T64_again();
        int[] num={2,3,4,2,6,2,5,1};
        ArrayList<Integer> res=t.maxInWindows(num,3);
        for (Integer a:res)
            System.out.print(a+",");
    }
}
