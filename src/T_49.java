import java.util.regex.Pattern;

/**
 * @author aliyang
 * @date 18-5-11 上午10:51
 * 把字符串转换成整数：我的解法
 * 思路：先将头尾的空格去掉，然后正则表达式判断是否是正负号(可以没有)+纯数字，然后判断是否由正负号，然后从后往前计算
 */
public class T_49 {

    public int StrToInt(String str) {

        if(str.equals("")||str.length()==0)
            return 0;

        int j=0;
        while (str.charAt(j)==' ')
            j++;

        int k=str.length()-1;
        while (str.charAt(k)==' ')
            k--;

        str=str.substring(j,k+1);

        if (Pattern.matches("^(-|\\+)?\\d+$",str)==false)
            return 0;

        boolean flag=false;//是否正负
        int left_index=-1;
        if (str.charAt(0)=='-'||str.charAt(0)=='+'){
            if (str.charAt(0)=='-'){
                flag=true;
            }
            left_index=1;
        }

        if (left_index==-1)
            left_index=0;

        int a=1;//位
        int res=0;
        for (int i=str.length()-1;i>=left_index;i--,a*=10){
            int val=str.charAt(i)-'0';
            res+=val*a;
        }
        if (flag==true)
            return -1*res;
        else return res;
    }

    public static void main(String[] args){
        T_49 t=new T_49();
        String str="123";
        System.out.println(t.StrToInt(str));

    }
}
