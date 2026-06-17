class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int left = 0;
        int right = 1;
        int best = 0;

        while(right < n){
            if(prices[right] > prices[left]){
                best = Math.max(prices[right] - prices[left], best);
            }
            else{
                left = right;
            }
            right++;
        }
        return best;
        
    }
}
