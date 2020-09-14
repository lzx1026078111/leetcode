//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 353 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k == 0) {
            return result;
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        solve(n, k, 0, deque);
        return result;
    }

    private void solve(int n, int k, int start, ArrayDeque<Integer> queue) {
        for (int i = start + 1; i <= n; i++) {
            if (queue.size() + (n - i + 1) < k) {
                return;
            }
            queue.add(i);
            if (queue.size() == k) {
                result.add(new ArrayList<>(queue));
            } else {
                solve(n, k, i, queue);
            }
            queue.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
