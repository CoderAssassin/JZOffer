import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author aliyang
 * @date 18-5-7 下午10:51
 * 字符串的排列：这题不会，别人解法
 * 思路：回溯法，交换每个位置的k值
 */
public class T_27 {

    public ArrayList<String> Permutation(String str) {

        ArrayList<String> res=new ArrayList<>();
        if (str!=null&&str.length()>0){
            PermutationHelper(str.toCharArray(),0,res);
            Collections.sort(res);
        }
        return res;
    }

    private void PermutationHelper(char[] cs, int i, List<String> list){
        if (i==cs.length-1){
            String val=String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        }else {
            for (int j=i;j<cs.length;j++){
                swap(cs,i,j);//将i后边的每个位置上的数依次和i位置上的数交换
                PermutationHelper(cs,i+1,list);//递归i位置变换后以i和i以前的位上的数为固定，后边的数变换的组合数
                swap(cs,i,j);//后边的组合数枚举完后得变回去
            }
        }
    }

    private void swap(char[] cs,int i,int j){
        char tmp=cs[i];
        cs[i]=cs[j];
        cs[j]=tmp;
    }
}
