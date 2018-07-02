/**
 * @Author:Aliyang
 * @Data: Created in 下午2:31 18-7-2'
 * 数组中的逆序对：二刷
 * 思路：采用归并排序，排序的过程中统计左右交换的次数
 **/
public class T35_again {

    public int InversePairs(int [] array) {

        if (array.length<2)
            return 0;
        int[] copy=new int[array.length];
        long count=merge(array,copy,0,array.length-1);
        return (int) (count%1000000007l);
    }

    private long merge(int[] array,int[] copy,int start,int end){

        if (start>=end)
            return 0;
        long sum=0;
        int mid=(start+end)/2;
        sum+=merge(array,copy,start,mid);//左路递归
        sum+=merge(array,copy,mid+1,end);//右路递归

        int i=start,j=mid+1,index=i;
        while (i<=mid&&j<=end){//进行排序
            if (array[i]>array[j]){//若右边比左边的小，那么更新逆序数对数，加上左边剩余的数，因为剩余的数都比右边这个数大
                copy[index++]=array[j++];
                sum+=mid-i+1;
            }
            else copy[index++]=array[i++];
        }
        while (i<=mid)
            copy[index++]=array[i++];
        while (j<=end)
            copy[index++]=array[j++];
        for (i=start;i<=end;i++)
            array[i]=copy[i];

        return sum;
    }

    public static void main(String[] args){
        T35_again t=new T35_again();
        int[] array={1,2,3,4,5,6,7,0};
        System.out.println(t.InversePairs(array));
        System.out.println(Integer.MAX_VALUE);
    }
}
