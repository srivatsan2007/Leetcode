class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // suf[i] = maximum number of characters
        // of word2 that can be matched from word1[i]
        int[] suf = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suf[i] = suf[i + 1] + 1;
                j--;
            } else {
                suf[i] = suf[i + 1];
            }
        }

        int[] ans = new int[m];

        int i = 0;
        j = 0;
        int count = 0;
        boolean changed = false;

        while (i < n && j < m) {

            if (word1.charAt(i) == word2.charAt(j)) {
                ans[count++] = i;
                i++;
                j++;
            } 
            else {
                // Use the one allowed mismatch
                if (!changed && suf[i + 1] >= m - j - 1) {
                    ans[count++] = i;
                    i++;
                    j++;
                    changed = true;
                } 
                else {
                    i++;
                }
            }
        }

        if (count != m) {
            return new int[0];
        }

        return ans;
    }
}