/**
 * @author aliyang
 * @date 18-5-11 上午11:37
 * 把字符串转换成整数：别人解法
 * 思路：
 */
public class T_49_1 {

    public int StrToInt(String str) {

        int n = str.length(), s = 1;
        long res = 0;
        if(n==0) return 0;
        if(str.charAt(0) == '-') s = -1;
        for(int i = (str.charAt(0) == '-' || str.charAt(0) == '+') ? 1 : 0; i < n; ++i){
            if(!('0' <= str.charAt(i) && str.charAt(i) <= '9')) return 0;
            res = (res << 1) + (res << 3) + (str.charAt(i) & 0xf);//res=res*10+str[i]-'0';
        }
        return (int)(res * s);
    }
}
