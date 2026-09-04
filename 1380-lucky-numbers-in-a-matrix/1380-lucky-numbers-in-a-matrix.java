class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {

            int small = matrix[i][0];
            int col = 0;

            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < small) {
                    small = matrix[i][j];
                    col = j;
                }
            }

            boolean lucky = true;

            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][col] > small) {
                    lucky = false;
                    break;
                }
            }

            if (lucky) {
                ans.add(small);
            }
        }

        return ans;
    }
}