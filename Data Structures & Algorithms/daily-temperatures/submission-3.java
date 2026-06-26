class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque();
        int[] out = new int[temperatures.length];

        for(int i= 0; i < temperatures.length;i++){
            int current = temperatures[i];
            while(!stack.isEmpty() && current > temperatures[stack.peek()]){
                int prev= stack.pop();
                out[prev] = i-prev;

            }
            stack.push(i);

        }

        return out;
        
    }
}
