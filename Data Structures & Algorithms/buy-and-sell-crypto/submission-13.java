class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int left = 0;
        for(int right = 0; right<prices.length;right++){
            if(prices[left] > prices[right]){
                left = right;
            }
            max = Math.max(max, prices[right] - prices[left]);
        }
        return max;
        
    }
}
