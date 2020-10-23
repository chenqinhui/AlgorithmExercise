package SortAlgorithm;

public class HeapSort {
    public void heapSort(int[] entry){
        int lastUnsorted;
        int count = entry.length;
        buildHeap(entry);
        for(lastUnsorted=count-1;lastUnsorted>0;lastUnsorted--){
            int current = entry[lastUnsorted];
            entry[lastUnsorted] = entry[0];
            insertHeap(entry,current,0,lastUnsorted-1);
        }
    }

    public void buildHeap(int[] entry){
        int count = entry.length;
        //从下到上，从右到左
        for(int low=count/2-1;low>=0;low--){
            int current = entry[low];
            insertHeap(entry,current,low,current-1);
        }
    }

    //从上到下，从左到右
    public void insertHeap(int[] entry, int current, int low,int high){
        int large;
        large = 2*low+1;
        while(large<=high){
            // 使large位置的数是low的儿子中最大的
            if(large<high&&entry[large]<entry[large+1]){
                large++;
            }
            if(current>=entry[large])
                break;
            else{
                entry[low] = entry[large];
                low = large;
                large = 2*low+1;
            }
        }
        entry[low] = current;
    }
}
