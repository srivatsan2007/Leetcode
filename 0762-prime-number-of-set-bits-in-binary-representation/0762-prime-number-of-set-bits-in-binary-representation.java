class Solution {
    public int countPrimeSetBits(int left, int right) {
     int answer = 0;
     for(int i = left; i <= right ; i++){
        int bit = Integer.bitCount(i);
        if(isPrime(bit)){
            answer++;
        }
     }
     return answer;   
    }
    private boolean isPrime(int n){
        if(n<2){
            return false;
        }
         for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}