import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int right = (position[position.length - 1] - position[0]) / (m - 1);
        int left = 1;
        int ans = 1;
        while (left <= right) {
            int distance = left + (right - left) / 2;
            if (check(position, distance, m)) {
                ans = distance;
                left = distance + 1;
            } else {
                right = distance - 1;
            }
        }
        return ans;
    }

    private boolean check(int[] position, int distance, int m) {
        int count = 1;
        int left = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - left >= distance) {
                count++;
                left = position[i];
                if (count == m) {
                    return true;
                }
            }
        }
        return false;
    }
}
