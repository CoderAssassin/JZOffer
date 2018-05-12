import java.util.ArrayList;
import java.util.Collections;

/**
 * @author aliyang
 * @date 18-5-12 下午5:12
 * 数据流中的中位数：我的解法
 * 思路：常规思路
 */
public class T_63 {

    ArrayList<Integer> arr=new ArrayList<>();
    public void Insert(Integer num) {
        arr.add(num);
    }

    public Double GetMedian() {

        Collections.sort(arr);
        int length=arr.size();
        if (length%2==1)
            return arr.get(length/2)*1.0;
        else return (arr.get(length/2-1)+arr.get(length/2))*1.0/2;
    }

    public static void main(String[] args){
        T_63 t=new T_63();

    }

}
