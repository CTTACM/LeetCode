package 数据结构.栈和队列;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 主辅栈：
 * 添加元素时：主栈正常，辅栈查看要插入的元素是否比当前的top值更小或者相等，只添加更小的
 *       如果top值为空，则把元素直接添加到主辅栈中
 * 删除元素时，查看主栈top与辅栈top是否相同，相同则都删除，否则只删除主栈元素
 * min时：取辅栈top
 */
public class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> aStack, bStack;

    public MinStack(){
        this.aStack = new Stack<>();
        this.bStack = new Stack<>();
    }

    public void push(int x) {
        if(aStack.empty() || x <= bStack.peek()) {
            aStack.push(x);
            bStack.push(x);
        } else{
            aStack.push(x);
        }
    }

    public void pop() {
        if(!aStack.empty()){
            if(aStack.peek().equals(bStack.peek())){
                aStack.pop();
                bStack.pop();
            }
            aStack.pop();
        }
    }

    public int top() {
        return aStack.peek();
    }

    public int min() {
        return bStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.pop();
        minStack.top();
        minStack.min();
    }
}
