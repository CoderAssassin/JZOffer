import java.util.Stack;

/**
 * @author aliyang
 * @date 18-5-7 下午1:38
 * 包含main函数的栈:我的解法
 * 别人解法的思路：两个栈，一个栈保存所有的数据，一个栈只入栈比当前上一次入栈的数小的数，最后pop()得到的是最小的值
 */
public class T_20 {

    Stack stack=new Stack();

    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        if (stack.empty())
            throw new RuntimeException("栈为空");
        stack.pop();
    }

    public int top() {
        if (stack.empty())
            throw new RuntimeException("栈为空");
        return (int)stack.peek();
    }

    public int min() {
        Stack tmp=new Stack();
        int min=Integer.MAX_VALUE;
        while (!stack.empty()){
            int val=(int)stack.peek();
            tmp.push(stack.pop());
            if (val<min)
                min=val;
        }
        while (!tmp.empty())
            stack.push(tmp.pop());
        return min;
    }
}
