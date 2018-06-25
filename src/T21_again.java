import java.util.Stack;

/**
 * @Author:Aliyang
 * @Data: Created in 下午6:44 18-6-25
 * 栈的压入、弹出序列：二刷
 * 思路：栈模拟，当前数相等，那么循环往前判断前面的数是否和popA后边的序列相等；不等，同样的判断，只是popA的索引从当前索引开始
 **/
public class T21_again {

    public boolean IsPopOrder(int [] pushA,int [] popA) {

        int index_push=0,index_pop=0;
        Stack<Integer> stack=new Stack<>();

        while (index_pop<popA.length&&index_push<pushA.length){

            if (pushA[index_push]!=popA[index_pop]){
                while (!stack.isEmpty()&&stack.peek()==popA[index_pop]){
                    stack.pop();
                    index_pop++;
                }
                stack.push(pushA[index_push++]);
            }else {
                index_pop++;
                index_push++;
                while (!stack.isEmpty()&&stack.peek()==popA[index_pop]){
                    stack.pop();
                    index_pop++;
                }
            }
        }
        if (index_push==pushA.length&&index_pop==popA.length)
            return true;
        else return false;
    }

    public static void main(String[] args){
        T21_again t=new T21_again();
        int[] pushA={1,2,3,4,5};
        int[] popA={4,3,5,1,2};
        System.out.println(t.IsPopOrder(pushA,popA));
    }
}
