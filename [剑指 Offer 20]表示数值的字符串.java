//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"012
//3"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。 
//
// 
// Related Topics 数学 
// 👍 77 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean isNumber(String s) {

        boolean hasE = false;
        boolean hasOp = false;
        boolean hasDot = false;
        boolean hasNum = false;
        s = s.trim();
        for (char c : s.toCharArray()) {
            if (c == 'e' || c == 'E') {
                if (hasE || !hasNum) {
                    return false;
                }
                hasE = true;
                hasOp = false;
                hasDot = false;
                hasNum = false;
                continue;
            }
            if (c == '-' || c == '+') {
                if (hasOp || hasNum || hasDot) {
                    return false;
                }
                hasOp = true;
                hasNum = false;
                continue;
            }
            if (c == '.') {
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
                continue;
            }
            if (c >= '0' && c <= '9') {
                hasNum = true;
                continue;
            } else {
                return false;
            }
        }
        return hasNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
