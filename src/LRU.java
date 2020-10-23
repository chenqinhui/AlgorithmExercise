import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class LRU {
    /*
    * 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
    set(key, value)：将记录(key, value)插入该结构
    get(key)：返回key对应的value值
    [要求]
    set和get方法的时间复杂度为O(1)
    某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
    当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
    若opt=1，接下来两个整数x, y，表示set(x, y)
    若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
    对于每个操作2，输出一个答案
    * */
    public int[] solution(int[][] operators, int k){
        List<Integer> result = new ArrayList<>();
        LinkedHashMap<Integer,Integer> keys = new LinkedHashMap<>();
        for (int[] operator : operators) {
            int opt = operator[0];
            int x = operator[1];
            // set(x,y)
            if (opt == 1) {
                if (keys.containsKey(x)) {
                    keys.remove(x);
                } else {
                    if (keys.size() == k) {
                        keys.remove(keys.keySet().toArray()[0]);
                    }
                }
                keys.put(x, operator[2]);
            }
            //get(x)
            else if (opt == 2) {
                if (keys.containsKey(x)) {
                    int val = keys.remove(x);
                    result.add(val);
                    keys.put(x, val);
                } else {
                    result.add(-1);
                }

            }

        }
        int[] out = new int[result.size()];
        for(int i=0;i<result.size();i++){
            out[i] = result.get(i);
        }
        return out;
    }
}
