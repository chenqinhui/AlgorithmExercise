package JianZhiOffer;

import java.util.LinkedList;
import java.util.Queue;

public class UseQueueToImpStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    public int pop(){
        int pop = -1;
        if(queue1.size()>0){
            while(queue1.size()>1){
                int temp = queue1.poll();
                queue2.offer(temp);
            }
            pop = queue1.poll();
        }
        else if(queue2.size()>0){
            while(queue2.size()>1){
                int temp = queue2.poll();
                queue1.offer(temp);
            }
            pop = queue2.poll();
        }
        return pop;
    }
    public void push(int add){
        if(queue2.size()>0)
            queue2.offer(add);
        else {
            queue1.offer(add);
        }
    }
    UseQueueToImpStack(){
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }
}

class M9_2{
    public static void main(String[] args){
        UseQueueToImpStack u = new UseQueueToImpStack();
        u.push(1);
        u.push(2);
        u.push(3);
        int pop = u.pop();
        System.out.println(pop);
        pop = u.pop();
        System.out.println(pop);
        pop = u.pop();
        System.out.println(pop);
    }
}
