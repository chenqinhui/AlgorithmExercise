public class QuickSort {
    void recursiveQuickSort(int[] data,int start,int end){
        if(start==end)
            return;
        if(start<end){
            int pivotPosition = partition(data,start,end);
            recursiveQuickSort(data,start,pivotPosition);
            recursiveQuickSort(data,pivotPosition+1,end);
        }
    }
    int partition(int[] data,int start,int end) {
        int pivot = data[start];
        int lastSmall = start;
        for (int i = start+1; i < end;i++){
            if(data[i]<pivot){
                lastSmall++;
                int temp = data[lastSmall];
                data[lastSmall] = data[i];
                data[i] = temp;
            }
        }
        int temp = data[start];
        data[start] = data[lastSmall];
        data[lastSmall] = temp;
        return lastSmall;
    }
//    void swap(int a,int b){
//        int temp = a;
//        a = b;
//        b = temp;
//    }
}

class QSort{
    public static void main(String[] args){
        QuickSort q = new QuickSort();
        int[] input = {4,7,2,1,5,3,8,6};
        q.recursiveQuickSort(input,0,input.length);
        for(int i:input){
            System.out.println(i);
        }
    }
}