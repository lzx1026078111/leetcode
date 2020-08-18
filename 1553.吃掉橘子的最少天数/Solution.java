class Solution {

    private Map<Integer, Integer> results = new HashMap<>();

    public int minDays(int n) {
        results.put(1, 1);
        results.put(2, 2);
        results.put(3, 2);
        return getMin(n);
    }

    private int getMin(int n) {
        Integer result = results.get(n);
        if (result != null) {
            return result;
        }
        int min2 = getMin(n / 2) + n % 2;
        int min3 = getMin(n / 3) + n % 3;
        result = Math.min(min2, min3) + 1;
        results.put(n, result);
        return result;
    }
}