import java.util.Arrays;
import java.util.Comparator;

/**
 * @author aliyang
 * @date 18-5-8 下午5:23
 * 把数组排成最小的数：别人解法
 * 思路：先转换成字符串数组，然后排序，排序规则如下：若ab<=ba，那么a<=b
 */
public class T_32 {

    public String PrintMinNumber(int [] numbers) {

        String[] str=new String[numbers.length];
        StringBuilder sb=new StringBuilder();

        for (int i=0;i<numbers.length;i++)
            str[i]=String.valueOf(numbers[i]);

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1=o1+o2;
                String s2=o2+o1;
                return s1.compareTo(s2);
            }
        });

        for (int i=0;i<numbers.length;i++)
            sb.append(str[i]);

        return sb.toString();
    }

    public static void main(String[] args){
        T_32 t=new T_32();
        int[] num=new int[]{3,32,321};
        System.out.println(t.PrintMinNumber(num));

    }
}
