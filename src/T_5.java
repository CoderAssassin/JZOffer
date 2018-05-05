import java.util.Stack;

/**
 * @author aliyang
 * @date 18-5-5 下午3:31
 * 用两个栈实现队列：我的解法
 */
public class T_5 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    int stack_num=1;//哪个栈当作栈
    public void push(int node) {
        if (stack_num==1)
            stack1.push(node);
        else stack2.push(node);
    }

    public int pop() {
        if (stack_num==1){//如果栈是1
            if (!stack2.empty())//说明stack2是前面转移后的队列
                return stack2.pop();
            else {//将stack1转移到stack2，这时stack2变成队列
                while (!stack1.empty()){
                    int element=stack1.pop();
                    stack2.push(element);
                }
                stack_num=1;
                return stack2.pop();
            }
        }else {
            if (!stack1.empty())//说明stack2是前面转移后的队列
                return stack1.pop();
            else {//将stack1转移到stack2，这时stack2变成队列
                while (!stack2.empty()){
                    int element=stack2.pop();
                    stack1.push(element);
                }
                stack_num=2;
                return stack1.pop();
            }
        }
    }

    public static void main(String[] args){

        T_5 t=new T_5();
        t.push(1);
        t.push(2);
        t.push(3);
        t.push(4);

        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
    }
}
