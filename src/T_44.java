/**
 * @author aliyang
 * @date 18-5-9 下午10:45
 * 翻转单词顺序列：我的解法
 * 思路：split一下，从后往前build
 */
public class T_44 {

    public String ReverseSentence(String str) {

        if (str==null||str.equals(""))
            return "";

        String[] strs=str.split(" ");
        if (strs.length==0)
            return str;
        StringBuilder sb=new StringBuilder();
        sb.append(strs[strs.length-1]);

        for (int i=strs.length-2;i>=0;i--){
            sb.append(" "+strs[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args){
        T_44 t=new T_44();
        String str="  ";
        System.out.println(t.ReverseSentence(str));

    }
}
