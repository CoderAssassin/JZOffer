/**
 * @author aliyang
 * @date 18-5-11 下午8:37
 * 表示数值的字符串：我的解法
 * 思路：疯狂地加条件判断语句
 */
public class T_53 {

    public boolean isNumeric(char[] str) {
        if (str.length==0)
            return false;

        boolean E_e=false;//是否由e
        boolean dot=false;//小数点个数

        for (int i=0;i<str.length;i++){
            if (!(str[i]=='+'||str[i]=='-'||str[i]=='.'||(str[i]>='0'&&str[i]<='9')||
                    str[i]=='e'||str[i]=='E'))
                return false;
            if (str[i]=='+'||str[i]=='-'){
                if (i==0&&i+1<str.length&&(str[i+1]=='e'||str[i+1]=='E'||str[i+1]=='-'||str[i+1]=='+'))
                    return false;
                if (i!=0&&!(str[i-1]=='e'||str[i-1]=='E'))
                    return false;
            }
            if (i==0&&(str[0]=='e'||str[0]=='E'||str[0]=='.'))
                return false;
            if (str[i]=='e'||str[i]=='E'){
                E_e=true;
                if ((i+1>=str.length)||
                        (i+1<str.length&&(str[i+1]=='e'||str[i+1]=='E')))
                    return false;
            }
            if (str[i] == '.') {
                if (dot==true)
                    return false;
                dot=true;
                if ((i+1>=str.length)
                        ||(i+1<str.length&&(str[i+1]=='+'||str[i+1]=='-'))||E_e==true)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        T_53 t=new T_53();
        char[] str=new char[]{'0','.','1','e','+','6'};
        System.out.println(t.isNumeric(str));

    }
}
