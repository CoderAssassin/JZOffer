import java.util.Stack;

/**
 * @author aliyang
 * @date 18-5-7 下午2:12
 * 栈的压入，弹出序列：有点困没撸出来，直接参考别人解法
 * 思路：借用一个栈，一个个将pushA的元素加入，每加入一个元素然后将popA的元素和pushA对比，若相等则直接
 * 从栈中pop出来，直到popA中的元素和B中的元素不相等，说明接下来的元素可能在pushA的后边，最后若栈不为空，说明
 * 有些数没有对上
 */
public class T_21 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {

        int lengthA=pushA.length,
                lengthB=popA.length;
        Stack stack=new Stack();
        for (int i=0,j=0;i<lengthA;){
            stack.push(pushA[i++]);
            while (j<lengthB&&(int)stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args){
        T_21 t=new T_21();
        int[] pushA=new int[]{1,2,3,4,5};
        int[] popA=new int[]{4,5,3,2,1};

        System.out.println(t.IsPopOrder(pushA,popA));


    }
}
