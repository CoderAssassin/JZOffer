/**
 * @author aliyang
 * @date 18-5-5 下午3:51
 * 旋转数组的最小数字:我的解答
 * 别人的解法差不多
 */
public class T_6 {

    public int minNumberInRotateArray(int [] array) {

        int length=array.length;
        if (length==0)
            return 0;

        int first=array[0];
        return minNumber(array,1,length-1,first);
    }

    private int minNumber(int[] array,int start,int end,int first){

        if (start==end)
            return array[start];

        int mid=(start+end)/2;
        if (array[mid]==first)
            return first;
        else if (array[mid]<first){
            end=mid;
            return minNumber(array,start,end,first);
        }else if (array[mid]>first){
            start=mid+1;
            return minNumber(array,start,end,first);
        }

        return 0;
    }

    public static void main(String[] args){
        T_6 t=new T_6();
        int[] a={3,4,5,1,2};
        System.out.println(t.minNumberInRotateArray(a));

    }

}
