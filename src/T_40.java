import java.util.Arrays;

/**
 * @author aliyang
 * @date 18-5-9 下午5:02
 * 数组中只出现一次的数字：我的解法
 * 思路：排序...然后遍历一遍
 */
public class T_40 {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        Arrays.sort(array);
        int count=1;
        int resnum=1;
        for (int i=1;i<array.length;i++){
            if (array[i]==array[i-1])
                count++;
            else {
                if (count==1){
                    if (resnum==1){
                        num1[0]=array[i-1];
                        resnum=2;
                    } else{
                        num2[0]=array[i-1];
                        resnum=3;
                    }
                }else count=1;
            }
        }
        if (resnum==2&&count==1)
            num2[0]=array[array.length-1];
    }

    public static void main(String[] args){
        T_40 t=new T_40();
        int[] a=new int[]{1,1,2,3,2,4,5,5,6,6};
        int[] res1=new int[1];
        int[] res2=new int[1];
        t.FindNumsAppearOnce(a,res1,res2);
    }
}
