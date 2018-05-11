import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author aliyang
 * @date 18-5-11 下午1:04
 * 数组中重复的数字：我的解法
 * 思路：用链表保存已经查过的数，用到额外的空间
 */
public class T_50 {

    public boolean duplicate(int numbers[],int length,int [] duplication) {

        if (length==0)
            return false;

        Set<Integer> keys=new LinkedHashSet<>();
        for (int i=0;i<length;i++){
            int num=numbers[i];
            if (keys.contains(num)==false)
                keys.add(num);
            else{
                duplication[0]=num;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        T_50 t=new T_50();
        int[] a=new int[]{2,3,1,0,2,5,3};
        int[] res=new int[1];
        System.out.println(t.duplicate(a,a.length,res));
        System.out.println(res[0]);
    }
}
