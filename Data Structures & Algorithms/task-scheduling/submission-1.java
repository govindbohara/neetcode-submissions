class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        HashMap<Character,Integer> freq = new HashMap();

        int time = 0;
        for(char t: tasks){
            freq.put(t, freq.getOrDefault(t,0)+1);
        }
        for(int c: freq.values()){
            maxHeap.offer(c);
        }
        Deque<int[]> cooldown = new ArrayDeque();

        while(!maxHeap.isEmpty() || !cooldown.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int count = maxHeap.poll();
                count--;
                if(count > 0){
                    cooldown.addLast(new int[]{count, time + n});
                }
            } 
            if(!cooldown.isEmpty() && cooldown.getFirst()[1] == time){
                maxHeap.offer(cooldown.removeFirst()[0]);
            }
        }

        return time;
        
    }
}
