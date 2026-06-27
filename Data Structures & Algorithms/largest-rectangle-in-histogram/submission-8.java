class Pair {
    int index;
    int height;

    Pair(int i, int h){
        this.index= i;
        this.height = h;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Pair> stack = new ArrayDeque();
        int maxArea = 0;

        for(int i =0; i<heights.length; i++){
            int curr = heights[i];
            int start = i;
            while(!stack.isEmpty() && curr < stack.peek().height){
                Pair p = stack.pop();
                maxArea = Math.max(maxArea, p.height *(i-p.index));
                start = p.index;
            }
            stack.push(new Pair(start, curr));
        }

        while(!stack.isEmpty()){
            Pair p = stack.pop();
            maxArea = Math.max(p.height * (heights.length - p.index), maxArea);
        }

        return maxArea;
        
    }
}
