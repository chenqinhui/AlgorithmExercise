package LeetCode;
/*更优解：通过？：如果为链表当前位为null就置0来减少判断*/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int add = 0;
        ListNode l3 = null;
        ListNode current = null;
        ListNode pre = null;
        while(l1!=null||l2!=null){
            if(l1!=null&&l2!=null) {
                sum = l1.val + l2.val + add;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1!=null) {
                sum = l1.val + add;
                l1 = l1.next;
            }
            else{
                sum = l2.val + add;
                l2 = l2.next;
            }
            if(sum/10!=0){
                add = sum/10;
                sum = sum%10;
            }
            else{
                add = 0;
            }
            if(current!=null) {
                pre = current;
                current = new ListNode(sum);
                pre.next =current;
            }
            else{
                current = new ListNode(sum);
                l3 = current;
            }
        }
        if(add!=0)
            current.next = new ListNode(add);
        return l3;
    }
}

class Solution2{
    public static void main(String[] args){
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode l1 = new ListNode(9);
        ListNode l1_2 = new ListNode(9);
        ListNode l1_3 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l2_2 = new ListNode(9);
        l1.next = l1_2;
        l1_2.next = l1_3;
        l2.next = l2_2;
//        l2_2.next = l2_3;
        ListNode l = a.addTwoNumbers(l1,l2);
        while(l!=null){
            System.out.println(l.val);
            l = l.next;
        }
    }
}
