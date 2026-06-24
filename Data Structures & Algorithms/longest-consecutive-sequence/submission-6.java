class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();

        for(int i= 0; i<  nums.length;i++){
            set.add(nums[i]);
        }
        
        int count = 0;

        for(int i = 0; i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int curr = nums[i];
                int len = 1;

                while(set.contains(curr+1)){
                    len++;
                    curr++;
                }
                count = Math.max(len, count);

            };
        }

        return count;
    }
} 
