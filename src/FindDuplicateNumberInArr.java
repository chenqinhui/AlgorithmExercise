public class FindDuplicateNumberInArr {


    public void solution1(){
        int n = 7;
        int[] arr = {2,3,1,0,2,5,3};
        int[] c = new int[n];
        for(int i=0;i<arr.length;i++){
            int current = arr[i];
            c[current]+=1;
        }
        for(int i=0;i<c.length;i++){
            if(c[i]>1)
                System.out.println(i);
        }
    }

    //swap
    public boolean solution2() {
        int n = 7;
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    System.out.println(arr[i]);
                    return true;
                }
                int temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = temp;
            }
        }
        return false;
    }

    //binary search
    public void solution3(){
        int[] arr = {2,3,1,4,3};
        int n = arr.length;
        int start = 0;
        int mid = (n+1)/2;
        int count;
        while(mid>start){
            count = count(arr,start,mid);
            if(count>mid-start){
                mid = (mid+1)/2;
            }
            else{
                int temp = (mid-start)/2;
                start = mid;
                mid = start + temp;
            }
        }
        System.out.println(start+1);
    }

    //计算了范围在start~end之间的数的个数（不包括start）
    private int count(int[] arr,int start,int end){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=end&&arr[i]>start)
                count++;
        }
        return count;
    }
}

class M3{
    public static void main(String[] args){
        FindDuplicateNumberInArr find = new FindDuplicateNumberInArr();
        find.solution3();
    }

}
