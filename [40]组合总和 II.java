//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 377 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    private Set<String> set = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        combine(candidates, target, 0, 0, deque);
        return result;
    }

    private void combine(int[] candidates, int target, int sum, int index, ArrayDeque<Integer> deque) {
        if (index >= candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                return;
            } else if (sum + candidates[i] == target) {
                buildResult(candidates[i], deque);
            } else {
                deque.addLast(candidates[i]);
                combine(candidates, target, sum + candidates[i], i + 1, deque);
                deque.removeLast();
            }
        }
    }

    private void buildResult(int element, ArrayDeque<Integer> deque) {
        StringBuilder builder = new StringBuilder();
        for (Integer integer : deque) {
            builder.append(integer);
            builder.append(",");
        }
        builder.append(element);
        String strResult = builder.toString();
        if (!set.contains(strResult)) {
            set.add(strResult);
            List<Integer> m = new ArrayList<>(deque);
            m.add(element);
            result.add(m);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
