/**
 * @Author:Aliyang
 * @Data: Created in 下午2:01 18-7-3
 * 正则表达式匹配：二刷
 * 思路：先分成第二个字符是否是*，然后是*的话，分成匹配0次，1次和多次三种情况
 **/
public class T52_again {

    public boolean match(char[] str, char[] pattern)
    {
        if (str==null||pattern==null)
            return false;
        return matches(str,0,pattern,0);
    }

    private boolean matches(char[] str,int i,char[] pattern,int j){

        if (i==str.length&&j==pattern.length)
            return true;
        if (i!=str.length&&j==pattern.length)
            return false;

        if (j+1<pattern.length&&pattern[j+1]=='*'){//模式的下一个字符是*
            if ((i!=str.length&&str[i]==pattern[j])||(i!=str.length&&pattern[j]=='.')){//如果第一个字符匹配上
                return matches(str,i,pattern,j+2)//匹配0次
                        ||matches(str,i+1,pattern,j+2)//匹配1次
                        ||matches(str,i+1,pattern,j);//匹配多次
            }else return matches(str,i,pattern,j+2);//如果第一个字符没匹配上，那匹配0个
        }

        if ((i!=str.length&&str[i]==pattern[j])||(i!=str.length&&pattern[j]=='.'))
            return matches(str,i+1,pattern,j+1);

        return false;
    }

    public static void main(String[] args){
        T52_again t=new T52_again();
        char[] str="a".toCharArray();
        char[] pattern=".".toCharArray();
        System.out.println(t.match(str,pattern));
    }
}
