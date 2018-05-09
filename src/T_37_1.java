/**
 * @author aliyang
 * @date 18-5-9 下午3:47
 * 数字在排序数组中出现的次数：别人解法
 * 思路：搜索k-0.5和k+0.5的插入位置，然后减一下，溜
 */
public class T_37_1 {

    public int GetNumberOfK(int [] array , int k) {
        return biSearch(array,k+0.5)-biSearch(array,k-0.5);
    }

    private int biSearch(int[] array,double num){
        int s=0,e= array.length-1;
        while (s<=e){
            int mid=(e-s)/2+s;
            if (array[mid]<num)
                s=mid+1;
            else if (array[mid]>num)
                e=mid-1;
        }
        return s;
    }
}
