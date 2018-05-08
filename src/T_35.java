/**
 * @author aliyang
 * @date 18-5-8 下午8:50
 * 数组中的逆序对：我的解法超时，时间复杂度O(n^2)，题目有点难
 * 别人解法：归并算法的思想
 */
public class T_35 {

//    public int InversePairs(int [] array) {
//
//        if (array.length==0)
//            return 0;
//        int count=0;
//
//        for (int i=1;i<array.length;i++){
//            int val=array[i];
//            int j=i-1;
//            for (;j>=0;j--){
//                if (array[j]>val){
//                    array[j+1]=array[j];
//                    count++;
//                }else break;
//            }
//            array[j+1]=val;
//        }
//        return count;
//    }

    public int InversePairs(int [] array) {

        int length=array.length;
        if (length<=0)
            return 0;

        int[] copy=new int[array.length];
        for (int i=0;i<length;i++)
            copy[i]=array[i];
        long count=InversePairsCore(array,copy,0,length-1);
        return (int)(count%1000000007);
    }

    private long InversePairsCore(int[] data,int[] copy,int start,int end){

        if (start==end){
            copy[start]=data[start];
            return 0;
        }

        int length=(end-start)/2;
        long left=InversePairsCore(copy,data,start,start+length);//左边部分递归
        long right=InversePairsCore(copy,data,start+length+1,end);//右边部分递归

        int i=start+length;
        int j=end;
        int indexcopy=end;
        long count=0;
        while (i>=start&&j>=start+length+1){//从右往左遍历每个子部分
            if (data[i]>data[j]){
                copy[indexcopy--]=data[i--];//从右往左复制到合并后的数组中
                count=count+j-start-length;//加上右边的数组比较的数的左边部分的元素个数(包括比较的元素)
            }
            else {
                copy[indexcopy--]=data[j--];
            }
        }
        for (;i>=start;i--)
            copy[indexcopy--]=data[i];
        for (;j>=start+length+1;j--)
            copy[indexcopy--]=data[j];
        return left+right+count;
    }

    public static void main(String[] args){

        T_35 t=new T_35();
        int[] a=new int[]{1,2,3,4,5,6,7,0};
        System.out.println(t.InversePairs(a));
    }

}
