public class SortAlgorithm {
    public void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            for(int j=i;(j>0)&&(arr[j]<arr[j-1]);j--){
                swap(arr,j,j-1);
            }
        }
    }

    public void bubbleSort(int[] arr){
        for(int j=arr.length;j>=0;j--){
            for(int i=1;i<j;i++){
                if(arr[i-1]>arr[i]){
                    swap(arr,i-1,i);
                }
            }
        }
    }

    public void selectSort(int[] arr){
        for(int i=arr.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[i])
                    swap(arr,j,i);
            }
        }
    }

    public void mergeSort(int[] arr,int low,int high){
        if(low<high){
        int mid = (low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,mid+1,high);
        }
    }

    public void merge(int[] arr,int start1,int end1,int start2,int end2){
        int i,j;
        i=start1;
        j=start2;
        int[] temp = new int[end2-start1+1];
        int pos = 0;
        while(i<=end1&&j<=end2){
            if(arr[i]>arr[j]){
                temp[pos] = arr[j];
                j++;
            }
            else {
                temp[pos] = arr[i];
                i++;
            }
            pos++;
        }
        while (i <= end1) {
            temp[pos++]=arr[i++];
        }
        while(j<=end2){
            temp[pos++]=arr[j++];
        }
        int m = start1;
        for(int t : temp){
            arr[m]=t;
            m++;
        }
    }

    public void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

class SortMain{
    public static void main(String[] args){
        int[] arr = {4,2,1,6,3,6,0,-5,1,1};
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
//        sortAlgorithm.insertSort(arr);
//        sortAlgorithm.bubbleSort(arr);
//        sortAlgorithm.selectSort(arr);
        sortAlgorithm.mergeSort(arr,0,arr.length-1);
        for(int a:arr){
            System.out.println(a);
        }
    }
}
