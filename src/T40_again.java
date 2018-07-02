/**
 * @Author:Aliyang
 * @Data: Created in 下午4:35 18-7-2
 * 数组中只出现一次的数字：二刷
 **/
public class T40_again {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        if (array==null||array.length<2)
            return;

        int tmp=0;
        for (int i=0;i<array.length;i++)//获得两个不同的数的异或结果
            tmp^=array[i];

//        找到右边第一个位置为1的数，这个数将异或的数拆成两组，一组包含那个该位置为1的剩余数，一组是包含那个位置不为1的剩余数
        int first=0;
        for (int i=0;i<32;i++){
            if ((tmp & (1<<i))!=0){
                first=tmp & (1<<i);
                break;
            }
        }
//        遍历分组获得两个剩余数
        for (int i=0;i<array.length;i++){
            if ((array[i]&first)!=0)
                num1[0]^=array[i];
            else num2[0]^=array[i];
        }
    }
}
