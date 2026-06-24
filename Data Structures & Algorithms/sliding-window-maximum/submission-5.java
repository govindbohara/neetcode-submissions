class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int out[] = new int[nums.length-k+1];
        int count =0;

        Deque<Integer> q = new ArrayDeque();

        for(int right=0; right<nums.length;right++){
            while(!q.isEmpty() && nums[right] >= nums[q.getLast()]){
                q.removeLast();
            }
            q.addLast(right);
            if(q.getFirst() <= right-k){
                q.removeFirst();
            }
            if(right+1 >=k){
                out[count++] = nums[q.getFirst()];
            }

        }


        return out;
        
    }
}
