/**
 * @Author:Aliyang
 * @Data: Created in 下午8:51 18-7-2
 * 数组中重复的数字：二刷
 **/
public class T50_again {

    public boolean duplicate(int numbers[],int length,int [] duplication) {

        for (int i=0;i<length;i++){
            int index=numbers[i];
            if (index>=length)
                index-=length;
            if (numbers[index]>=length){
                duplication[0]=index;
                return true;
            }
            numbers[index]+=length;
        }
        return false;
    }

    public static void main(String[] args){
        T50_again t=new T50_again();
        int[] numbers={2,1,3,1,4};
        int[] duplication=new int[1];
        System.out.println(t.duplicate(numbers,numbers.length,duplication)+","+duplication[0]);
    }
}
