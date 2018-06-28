import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author:Aliyang
 * @Data: Created in 下午10:06 18-6-28
 * 把数组排成最小的数：二刷
 * 思路：ab<=ba，则a<b
 **/
public class T32_again {

    public String PrintMinNumber(int [] numbers) {

        StringBuilder sb=new StringBuilder();
        String[] str=new String[numbers.length];
        for (int i=0;i<numbers.length;i++)
            str[i]=String.valueOf(numbers[i]);

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });

        for (int i=0;i<str.length;i++)
            sb.append(str[i]);
        return sb.toString();
    }

}
