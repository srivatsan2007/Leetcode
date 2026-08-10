class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        // dp[i] = true if the current player can win with i stones

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;

                // If removing this square leaves a losing position
                if (!dp[i - square]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}