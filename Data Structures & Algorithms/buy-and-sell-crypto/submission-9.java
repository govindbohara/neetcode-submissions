class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int best = 0;
        int minPrice = prices[0];

        for(int i =1; i<n;i++){
            minPrice = Math.min(prices[i], minPrice);

            best = Math.max(prices[i] - minPrice, best);
        }
        
        return best;
        
    }
}
