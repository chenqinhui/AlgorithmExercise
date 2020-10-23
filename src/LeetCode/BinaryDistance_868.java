package LeetCode;

public class BinaryDistance_868 {
    public int binaryGap(int n) {
        int start = -1;
        int end = -1;
        int pos = -1;
        int result = 0;
        while(n!=0){
            pos++;
            int mod = n%2;
            n = n/2;
            if(mod==1){
                if(start==-1&&end==-1)
                    start = pos;
                else if(start!=-1&&end==-1){
                    end = pos;
                    result = end-start;
                }
                else{
                    start = end;
                    end = pos;
                    if(end-start>result){
                        result = end-start;
                    }
                }
            }
        }
        if(start==-1||end==-1)
            return 0;
        return result;
    }
}

class Solution868{
    public static void main(String[] args){
        BinaryDistance_868 b = new BinaryDistance_868();
        int result = b.binaryGap(29);
        System.out.println(result);
    }
}
