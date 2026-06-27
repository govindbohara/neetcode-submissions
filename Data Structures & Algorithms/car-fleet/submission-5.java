class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] arr = new int[position.length][2];
        Deque<Double> stack = new ArrayDeque();

        for(int i= 0;i<position.length;i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a,b)-> Integer.compare(a[0],b[0]));

        for(int i=arr.length-1; i>=0;i--){
            double time = (double)(target - arr[i][0])/arr[i][1];
            stack.push(time);
            if(stack.size()>= 2){
                double curr = stack.pop();
                double front = stack.peek();
                if(curr > front){
                    stack.push(curr);
                }
            }
        }

        return stack.size();
        
    }
}
