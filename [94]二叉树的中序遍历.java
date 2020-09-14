//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 688 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) {
 * val = x; } }
 */
class Solution {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        reverse(root);
        return result;
    }

    private void reverse(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            reverse(node.left);
        }
        result.add(node.val);
        if (node.right != null) {
            reverse(node.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
