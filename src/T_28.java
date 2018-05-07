/**
 * @author aliyang
 * @date 18-5-7 下午11:35
 * 数组中出现次数超过一半的数字：我的解法
 * 思路：两个索引指针一起来，缩短一半的时间
 */
public class T_28 {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length==0)
            return 0;

        int[] count=new int[10];//计数数组
        int i=0,j=array.length/2;

        for (;i<array.length/2;i++,j++){
            count[array[i]]++;
            count[array[j]]++;
        }
        if (array.length%2==1)
            count[array[j]]++;


        for (i=0;i<10;i++){
            if (count[i]>=array.length/2+1)
                return i;
        }
        return 0;
    }

    public static void main(String[] args){
        T_28 t=new T_28();
        int[] a=new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(t.MoreThanHalfNum_Solution(a));
    }
}
