public class GetLeastNumbers {
    void getLeastNumbers(int[] arr,int n,int k){
        int start = 0;
        int end = n-1;
        int index = partition(arr,n,start,end);
        while(index!=k-1){
            if(index<=k-1){
                start = index+1;
                index = partition(arr,n,start,end);
            }
            else{
                end = index-1;
                index = partition(arr,n,start,end);
            }
        }
        for(int i=0;i<k;i++){
            System.out.println(arr[i]);
        }
    }

    int partition(int[] arr, int n, int low, int high){
        int lastSmall = low;
        int pivot = arr[low];
        for(int i=low+1;i<=high;i++){
            if(arr[i]<pivot){
                lastSmall++;
                swap(arr,lastSmall,i);
            }
        }
        swap(arr,lastSmall,low);
        return lastSmall;
    }

    void swap(int[] arr,int a, int b){
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}

class M40{
    public static void main(String[] args){
        GetLeastNumbers g = new GetLeastNumbers();
        int[] arr = {4,2,-5,6,3,6,0,-5,9,10};
        int k = 4;
        g.getLeastNumbers(arr,arr.length,k);
    }
}
