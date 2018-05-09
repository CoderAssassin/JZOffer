/**
 * @author aliyang
 * @date 18-5-9 下午9:59
 * 左旋转字符串：我的解法
 * 注意：n得取个模
 *
 * 别人的解法：将两个字符串串起来，然后取n到len的字符
 */
public class T_43 {

    public String LeftRotateString(String str,int n) {

        if (str.equals("")||str==null)
            return "";

        StringBuilder sb=new StringBuilder();
        int length=str.length();
        int move=n%length;
        sb.append(str.substring(move,length));
        sb.append(str.substring(0,move));
        return sb.toString();
    }

    public static void main(String[] args){
        T_43 t=new T_43();
        String str="abcXYZdef";
        System.out.println(t.LeftRotateString(null,6));

    }
}
