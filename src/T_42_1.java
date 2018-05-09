import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-5-9 下午10:07
 * 和为S的两个数字：别人解法
 * 思路：
 * 数列满足递增，设两个头尾两个指针i和j，
 * 若ai + aj == sum，就是答案（相差越远乘积越小）
 * 若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j -= 1
 * 若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i += 1
 * O(n)
 */
public class T_42_1 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> res=new ArrayList<>();
        int n=array.length;
        int i=0,j=n-1;
        while (i<j){
            if (array[i]+array[j]==sum){
                res.add(array[i]);
                res.add(array[j]);
                break;
            }
            while (i<j&&array[i]+array[j]>sum) --j;
            while (i<j&&array[i]+array[j]<sum) ++i;
        }
        return res;     
    }
}
