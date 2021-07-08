//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//示例 1:
//
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//示例 2:
//
//输入: nums = [1], k = 1
//输出: [1]
//说明：
//
//你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
//你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num: nums){
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) ->map.get(a) - map.get(b)
        );
        for (int key: map.keySet()){
            if (pq.size() < k)
                pq.add(key);
            else if(map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }

        LinkedList<Integer> ret = new LinkedList<>();
        while (!pq.isEmpty())
            ret.add(pq.remove());
        return ret;

    }
}
