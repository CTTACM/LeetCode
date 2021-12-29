package 数据结构.栈和队列;

import java.util.Stack;

/**
 * @author admin
 * @description: TODO
 * @date 2021/12/2918:52
 */

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 主辅栈
 */
public class CQueue {
    private Stack<Integer> aStack1, aStack2;
    public void appendTail(int value){
        while (!aStack2.empty()){
            aStack1.push(aStack2.pop());
        }
        aStack1.push(value);
        while (!aStack1.empty()){
            aStack2.push(aStack1.pop());
        }
    }
    public int deleteHead(){
        if(aStack2.empty()) return -1;
        return aStack2.pop();
    }
    public CQueue(){
        this.aStack1 = new Stack<>();
        this.aStack2 = new Stack<>();
    }

}
