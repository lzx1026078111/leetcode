//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 465 👎 0
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;


class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int num : nums) {
            maps.merge(num, 1, Integer::sum);
        }
        Queue<Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Entry<Integer, Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Entry<Integer, Integer> entry : maps.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry);
            } else {
                if (entry.getValue() > queue.peek().getValue()) {
                    queue.remove();
                    queue.add(entry);
                }
            }
        }
        return queue.stream().mapToInt(item -> item.getKey()).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
