package JianZhiOffer;

public class FindMin {
    //寻找旋转数组的最小元素
    int solution(int[] data,int low,int high){
        int result = 0;
        if(low<high){
            int middle = (low+high)/2;
            if(data[middle]>data[low]){
                low = middle+1;
                result = solution(data,low,high);
            }
            else{
                high = middle;
                result = solution(data,low,high);
            }

        }
        return result;
    }
}

class M11{
    public static void main(String[] args){
        int[][] x= {{1,2}};
        FindMin f = new FindMin();
        int[] input = {7,8,9,1,2,4,6};
        int result = f.solution(input,0,7);
        System.out.println(result);
    }
}
