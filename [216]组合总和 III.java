//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 176 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if ((1 + k) * k / 2 > n || (19 - k) * k / 2 < n) {
            return result;
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        combine(n, 0, 1, k, deque);
        return result;
    }

    private void combine(int target, int sum, int index, int k, ArrayDeque<Integer> path) {
        if (index > 9 || path.size() > k) {
            return;
        }
        for (int i = index; i <= 9; i++) {
            if (sum + i > target) {
                return;
            } else if (sum + i == target) {
                if (path.size() + 1 == k) {
                    List<Integer> element = new ArrayList<>(path);
                    element.add(i);
                    result.add(element);
                }
                return;
            } else {
                path.addLast(i);
                combine(target, sum + i, i + 1, k, path);
                path.removeLast();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
