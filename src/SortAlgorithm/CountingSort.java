package SortAlgorithm;

public class CountingSort {
    //计数排序
    public int[] solution(int[] data,int n){
        int[] arr = new int[n+1];
        for(int i=0;i<data.length;i++){
            arr[data[i]]++;
        }
        for(int i=1;i<n+1;i++){
            arr[i] += arr[i-1];
        }
        int[] output = new int[data.length];
        for(int i:data){
            output[arr[i]-1] = i;
            arr[i]--;
        }
        return output;
    }
}

class Sort1{
    public static void main(String[] args){
        CountingSort q = new CountingSort();
        int[] input = {4,8,2,1,5,3,8,6};
        int[] output = q.solution(input,8);
        for(int i:output){
            System.out.println(i);
        }
    }
}
