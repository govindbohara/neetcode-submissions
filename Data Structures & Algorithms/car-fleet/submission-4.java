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
            if(!stack.isEmpty() && time <= stack.peek()){
                continue;
            }
            stack.push(time);

        }

        return stack.size();
        
    }
}
