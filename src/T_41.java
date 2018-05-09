import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-5-9 下午8:07
 * 和为S的连续整数序列：我的解法
 * 思路：从2开始遍历子序列的长度，若长度为奇数，那么sum/2为中间子序列的中间数，而且必须是整数，往左取一个则必定往右取一个；
 * 如果长度为偶数，那么sum/2的小数部分×i==i/2。根据等差数列，长度最长为Math.sqrt(2*sum)
 */
public class T_41 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum==0)
            return new ArrayList<ArrayList<Integer>>();

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<ArrayList<Integer>> reverseRes=new ArrayList<>();

//        for (int i=2;i<=sum;i++){
        for (int i=2;i<=Math.sqrt(2*sum);i++){

            if (i%2==0){//i是奇数，那么小数位需要是5
                if (sum/i-(i/2-1)<=0)
                    break;
                if (sum%i==i/2){
                    ArrayList<Integer> arrayList=new ArrayList<>();
                    int first=sum/i-(i/2-1);
                    for (int j=1;j<=i;j++){
                        arrayList.add(first);
                        first++;
                    }
                    res.add(arrayList);
                }
            }else {
                if (sum/2-(i/2)<=0)
                    break;
                if (sum%i==0){
                    int mid=sum/i;
                    int first=mid-(i/2);
                    ArrayList<Integer> arrayList=new ArrayList<>();
                    for (int j=1;j<=i;j++){
                        arrayList.add(first);
                        first++;
                    }
                    res.add(arrayList);
                }
            }
        }
        for (int i=res.size()-1;i>=0;i--)
            reverseRes.add(res.get(i));
        return reverseRes;
    }

    public static void main(String[] args){

        T_41 t=new T_41();
        ArrayList<ArrayList<Integer>> res=t.FindContinuousSequence(100);
        for (int i=0;i<res.size();i++){
            ArrayList<Integer> tmp=res.get(i);
            for (int j=0;j<tmp.size();j++)
                System.out.print(tmp.get(j)+" ");
            System.out.println();
        }
    }
}
