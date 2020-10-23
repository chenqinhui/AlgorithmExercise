package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        char[] sArr = s.toCharArray();
        Queue<Character> queue = new ArrayDeque<>();
        int length = s.length();
        int subLength = -1;
        for(int i=0;i<length;i++) {
            char c = sArr[i];
            if (!queue.contains(c)) {
                queue.offer(c);
            }
            else{
                if(queue.size()>subLength)
                    subLength = queue.size();
                while(!queue.isEmpty()&&!queue.peek().equals(c)){
                    queue.poll();
                }
                queue.poll();
                queue.offer(c);
            }
        }
        if(subLength<queue.size())
            subLength = queue.size();
        return subLength;
    }
}

class Solution3{
    public static void main(String[] args){
        LongestSubString l = new LongestSubString();
        int result = l.lengthOfLongestSubstring("abc");
        System.out.println(result);
    }
}
