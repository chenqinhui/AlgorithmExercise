package JianZhiOffer;

import java.util.Stack;

public class ReverseList {
    public ListNode solution(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while(current!=null){
            stack.push(current);
            current = current.next;
        }
        ListNode tail = stack.peek();
        current = tail;
        tail.next = current;
        while(!stack.empty()){
            stack.pop();
            if(!stack.empty()) {
                current.next = stack.peek();
                current = current.next;
            }
            else
                current.next = null;
        }
        return tail;
    }

//    public static ListNode solution2(ListNode head){
//        ListNode tail = null;
//        ListNode before = null;
//        while(head!=null){
//            int current = head.val;
//            ListNode next = head.next;
//            tail = new ListNode(current);
//            tail.next = before;
//            before = tail;
//            head = next;
//        }
//        return tail;
//    }
}

class M6{
    public static void main(String[] args){
        ReverseList r = new ReverseList();
        ListNode third = new ListNode(3);
        ListNode next = new ListNode(2);
        ListNode head = new ListNode(1);
        head.next = next;
        next.next = third;
        third.next = null;
        ListNode tail = r.solution(head);
        while(tail!=null){
            System.out.println(tail.val);
            tail = tail.next;
        }
    }
}
