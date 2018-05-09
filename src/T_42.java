import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-5-9 下午9:02
 * 和为S的两个数字：我的解法
 * 思路：小于等于sum/2的数是两个数中的小的数，利用二分查找，左边的数从小到大增加，若两个数都由，那么返回结果
 */
public class T_42 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if (array.length<=1)
            return new ArrayList<Integer>();

        int mid=sum/2;//第一个数的最大可能值
        int firstNum=1;//第一个数

        for (;firstNum<=mid;firstNum++){
            if (binarySearch(array,0,array.length-1,firstNum)!=-1){
                int secondNum=sum-firstNum;//第二个数
                if (binarySearch(array,0,array.length-1,secondNum)!=-1){
                    ArrayList<Integer> res=new ArrayList<>();
                    res.add(firstNum);
                    res.add(secondNum);
                    return res;
                }
            }
        }

        return new ArrayList<Integer>();
    }

    private int binarySearch(int[] array,int start,int end,int target){

        int mid=(start+end)/2;
        if (array[mid]==target)
            return mid;

        if (array[mid]>target&&mid-1>=start)
            return binarySearch(array,start,mid-1,target);
        if (array[mid]<target&&mid+1<=end)
            return binarySearch(array,mid+1,end,target);

        return -1;
    }

    public static void main(String[] args){
        T_42 t=new T_42();
        int[] a=new int[]{1,2,4,7,11,15};
        ArrayList<Integer> res=new ArrayList<>();
        res=t.FindNumbersWithSum(a,15);
        for (int i=0;i<res.size();i++)
            System.out.print(res.get(i)+" ");

    }
}
