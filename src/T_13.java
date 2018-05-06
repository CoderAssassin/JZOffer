/**
 * @author aliyang
 * @date 18-5-6 下午3:35
 * 调整数组顺序使奇数位于偶数前边:我的解法
 * 思路：找到奇数，插入排序
 */
public class T_13 {

    public void reOrderArray(int [] array) {

        for (int i=0;i<array.length;i++){
            int tmp=array[i];
            if (tmp%2==1){
                int j=i-1;
                for (;j>=0&&array[j]%2==0;j--)//偶数往后移
                    array[j+1]=array[j];
                array[j+1]=tmp;
            }
        }
    }
    public static void main(String[] args){
        T_13 t=new T_13();
        int[] a={0,1,2,3,4,5,6,7,8,9};
        t.reOrderArray(a);

    }


}
