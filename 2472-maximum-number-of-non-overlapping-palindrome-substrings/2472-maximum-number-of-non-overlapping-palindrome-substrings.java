class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            
            int left = i;
            int right = i;

            while (left >= 0 && right < n &&
                   s.charAt(left) == s.charAt(right)) {

                if (right - left + 1 >= k) {
                    dp[right + 1] = Math.max(dp[right + 1], dp[left] + 1);
                    break;
                }

                left--;
                right++;
            }

            
            left = i;
            right = i + 1;

            while (left >= 0 && right < n &&
                   s.charAt(left) == s.charAt(right)) {

                if (right - left + 1 >= k) {
                    dp[right + 1] = Math.max(dp[right + 1], dp[left] + 1);
                    break;
                }

                left--;
                right++;
            }
        }

        return dp[n];
    }
}