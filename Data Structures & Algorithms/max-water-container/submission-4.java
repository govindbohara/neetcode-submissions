class Solution {
    public int maxArea(int[] heights) {
        int best = 0;
        int left = 0;
        int right = heights.length-1;


        while(left < right){
        int distance = right -left;
            int minheight = Math.min(heights[left], heights[right]);
            int b = distance * minheight;

            System.out.println(distance + "," + minheight );

            best =Math.max(b, best);

            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return best;
        
    }
}
