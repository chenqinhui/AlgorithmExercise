package JianZhiOffer;

import java.util.Stack;

// 用栈实现队列
public class UseStackToImpQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    void appendTail(int tail){
        stack1.push(tail);
    }

    int deleteHead() {
        int delete = -1;
        if(!stack2.empty())
            delete = stack2.pop();
        else if(!stack1.empty()){
            while(!stack1.empty()) {
                int temp = stack1.pop();
                stack2.push(temp);
            }
            delete = stack2.pop();
        }
        else{
//            throw new Exception("Queue is empty!");
            System.out.println("Queue is empty!");
        }
        return delete;
    }

    UseStackToImpQueue(){
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }
}

class M9{
    public static void main(String[] args){
        UseStackToImpQueue u = new UseStackToImpQueue();
        u.appendTail(1);
        u.appendTail(2);
        u.appendTail(3);
        int pop = u.deleteHead();
        System.out.println(pop);
        pop = u.deleteHead();
        System.out.println(pop);
        pop = u.deleteHead();
        System.out.println(pop);
    }
}
