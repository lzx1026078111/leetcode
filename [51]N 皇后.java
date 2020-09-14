//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 552 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<String>> solveNQueens(int n) {
        int[][] checkBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                checkBoard[i][j] = 0;
            }
        }
        List<List<String>> result = new ArrayList<>();
        calcute(checkBoard, 0, n, result);
        return result;
    }

    private void calcute(int[][] checkBoard, int height, int n, List<List<String>> result) {
        for (int i = 0; i < n; i++) {
            if (judge(checkBoard, i, height, n)) {
                checkBoard[height][i] = 1;
                if (height == n - 1) {
                    result(checkBoard, result);
                } else {
                    calcute(checkBoard, height + 1, n, result);
                }
                checkBoard[height][i] = 0;
            }
        }
    }

    private void result(int[][] checkBoard, List<List<String>> result) {
        List<String> element = new ArrayList<>();

        for (int[] ints : checkBoard) {
            StringBuilder builder = new StringBuilder();
            for (int i : ints) {
                builder.append(i == 0 ? "." : "Q");
            }
            element.add(builder.toString());
        }
        result.add(element);
    }

    private boolean judge(int[][] checkBoard, int width, int height, int n) {
        int sum = 0;
        for (int i = 1; i <= height; i++) {
            sum += checkBoard[height - i][width];
            if (width - i >= 0) {
                sum += checkBoard[height - i][width - i];
            }
            if (width + i < n) {
                sum += checkBoard[height - i][width + i];
            }
        }
        return sum == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
