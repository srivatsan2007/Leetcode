class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans = 0;
        int n = baskets.length;

        for(int fruit : fruits){
            int i;

            for(i = 0; i < n; i++){
                if(baskets[i] >= fruit){
                baskets[i] = -1;
                break;
            }
        }
        if(i == n)
            ans++;
        }
        return ans;
    }
}