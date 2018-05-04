/**
 * @author aliyang
 * @date 18-5-4 下午9:40
 * 替换空格
 */
public class T_2 {

    public String replaceSpace(StringBuffer str){

        StringBuilder sb=new StringBuilder();
        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c==' '){
                sb.append("%20");
            }else sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args){

        StringBuffer sb=new StringBuffer();
        sb.append("We Are Happy ");
        T_2 t=new T_2();
        System.out.println(t.replaceSpace(sb));
    }
}
