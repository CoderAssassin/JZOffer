import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author aliyang
 * @date 18-5-8 下午7:55
 * 第一个只出现一次的字符：我的解法
 * 思路：一个Map记录节点出现的次数，一个数组记录首次出现的位置，遍历一遍str，然后遍历一遍map
 */
public class T_34 {

    public int FirstNotRepeatingChar(String str) {

        if (str==null||str.equals(""))
            return -1;
        if (str.length()==1)
            return 0;

        Map<Integer,Integer> count=new LinkedHashMap<>();
        int[] pos=new int[52];

        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            int int_c=-1;
            if (c>='a'&&c<='z'){
                int_c=c-'a'+26;
            }else if (c>='A'&&c<='Z'){
                int_c=c-'A';
            }
            if (pos[int_c]==0)//记录位置
                pos[int_c]=i+1;
            if (count.containsKey(int_c)==false)
                count.put(int_c,1);
            else count.put(int_c,count.get(int_c)+1);
        }

        Iterator it=count.keySet().iterator();
        while (it.hasNext()){
            int key=(int)it.next();
            if (count.get(key)==1)
                return pos[key]-1;
        }
        return 0;
    }

    public static void main(String[] args){
        T_34 t=new T_34();
        String str="google";
        System.out.println(t.FirstNotRepeatingChar(str));

    }
}
