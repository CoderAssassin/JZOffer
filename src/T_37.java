
/**
 * @author aliyang
 * @date 18-5-8 下午11:39
 * 数字在排序数组中出现的次数：我的解法
 * 思路：二分查找，找到最左边的和k相等的数，然后从左到右遍历计数
 */
public class T_37 {

    public int GetNumberOfK(int [] array , int k) {
        if (array.length==0)
            return 0;
        int left=find_Left(array,k,0,array.length-1);

        if (left==-1)
            return 0;


        int count=0;
        for (int i=left;i<array.length;i++){
            if (array[i]!=k)
                break;
            else count++;
        }
        return count;
    }

//    找到左边的第一个下标
    private int find_Left(int[] array,int k,int start,int end){

        if (start==end){
            if (array[start]==k)
                return start;
            else return -1;
        }

        int mid=(start+end)/2;

        int left=-1,
        right=-1;
        if (mid-1>=start&&(left=find_Left(array,k,start,mid-1))!=-1)
            return left;
        if (array[mid]==k)
            return mid;
        if (mid+1<=end&&(right=find_Left(array,k,mid+1,end))!=-1)
            return right;

        return -1;
    }

    public static void main(String[] args){
        T_37 t=new T_37();
        int[] a=new int[]{1,2,3,4,4,4};
        System.out.println(t.GetNumberOfK(a,4));

    }
}
