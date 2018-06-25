import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:Aliyang
 * @Data: Created in 下午8:39 18-6-25
 * 字符串的排列：二刷
 * 思路：dfs
 **/
public class T27_again {

    public ArrayList<String> Permutation(String str) {

        ArrayList<String> res=new ArrayList<>();
        if (str.length()==0||str.equals(""))
            return res;

        char[] strs=str.toCharArray();
        Arrays.sort(strs);
        boolean[] contains=new boolean[str.length()];
        deal(strs,res,new StringBuilder(),contains);
        return res;
    }

    private void deal(char[] strs, ArrayList<String> res, StringBuilder cur, boolean[] contains){

        if (cur.length()== strs.length){
            res.add(cur.toString());
            return;
        }

        Set<Character> dup=new HashSet<>();

        for (int i=0;i<strs.length;i++){
            if (!contains[i]&&!dup.contains(strs[i])){
                contains[i]=true;
                cur.append(strs[i]);
                dup.add(strs[i]);
                deal(strs,res,cur,contains);
                cur.deleteCharAt(cur.length()-1);
                contains[i]=false;
            }
        }
    }

    public static void main(String[] args){
        T27_again t=new T27_again();
        String str="abc";
        ArrayList<String> res=t.Permutation(str);
        for (String cur:res)
            System.out.print(cur+",");
    }
}
