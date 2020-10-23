package JianZhiOffer;

public class ReplaceBlank {
    public String solution(String input){
        int count = 0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)==' ')
                count++;
        }
        int length = input.length()+count*3-1;
        int pos = input.length()-1;
        char[] output=new char[length];
        for(int i=length-1;i>=0;i--){
            if(input.charAt(pos)!=' '){
                output[i] = input.charAt(pos);
            }
            else{
                output[i]='0';
                output[i-1]='2';
                output[i-2]='%';
                i=i-2;
            }
            pos-=1;
        }
        return new String(output);
    }
}

class M5{
    public static void main(String[] args){
        ReplaceBlank r = new ReplaceBlank();
        String output = r.solution("Hello World");
        System.out.println(output);
    }
}
