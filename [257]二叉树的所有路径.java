//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 336 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) {
 * val = x; } }
 */
//public class TreeNode {
//
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}

class Solution {

    private List<String> result;

    public List<String> binaryTreePaths(TreeNode root) {
        Deque<Integer> queue = new ArrayDeque();
        result = new ArrayList<>();

        dfs(root, queue);
        return result;
    }

    private void dfs(TreeNode node, Deque<Integer> queue) {
        if (node == null) {
            return;
        }
        queue.addLast(node.val);
        if (node.left != null) {
            dfs(node.left, queue);
        }
        if (node.right != null) {
            dfs(node.right, queue);
        }
        if (node.left == null && node.right == null) {
            getResult(queue);
        }
        queue.removeLast();
    }

    private void getResult(Deque<Integer> deque) {
        result.add(deque.stream().map(item -> item.toString()).collect(Collectors.joining("->")));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
