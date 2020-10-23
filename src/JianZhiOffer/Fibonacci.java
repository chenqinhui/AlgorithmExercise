package JianZhiOffer;

public class Fibonacci {
    //递归实现
    public int solution(int input){
        if(input==1)
            return 1;
        if(input<=0)
            return 0;
        return solution(input-1)+solution(input-2);
    }

    //非递归实现
    public int solution2(int input){
        if(input==0)
            return 0;
        if(input==1)
            return 1;
        int first = 0;
        int second = 1;
        int result = 0;
        for(int i=2;i<=input;i++){
            result = first+second;
            first = second;
            second = result;
        }
        return result;
    }
}

class M10{
    public static void main(String[] args){
        Fibonacci f = new Fibonacci();
        int result = f.solution2(9);
        System.out.println(result);
    }
}