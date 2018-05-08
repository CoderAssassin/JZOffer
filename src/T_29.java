import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author aliyang
 * @date 18-5-8 下午1:31
 * 最小的k个数：我的解法
 * 思路：没有什么技巧，排个序，然后选前k个数
 */
public class T_29 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        if (input.length<k)
            return new ArrayList<Integer>();

        ArrayList res=new ArrayList<>();
        Arrays.sort(input);

        for (int i=0;i<k;i++)
            res.add(input[i]);
        return res;
    }

    public static void main(String[] args){
        T_29 t=new T_29();
        int[] a=new int[]{4,5,1,6,2,7,3,8};
        ArrayList res=t.GetLeastNumbers_Solution(a,4);
        for (int i=0;i<res.size();i++)
            System.out.print(res.get(i)+" ");

    }
}
