class MedianFinder {
    int median  = 0;
    PriorityQueue<Integer> minHeap ;

    public MedianFinder() {
        minHeap = new PriorityQueue();

        
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        
    }
    
    public double findMedian() {
        PriorityQueue<Integer> temp = new PriorityQueue(minHeap);
    
        int size = minHeap.size();
        if(size % 2 != 0){
            for(int i = 0; i<size/2; i++){
                temp.poll();
            }
            return temp.peek();
        }else{
            for(int i= 0; i<size/2 -1; i++){
                temp.poll();
            }
            int a = temp.poll();
            int b = temp.peek();
            return (a+b)/2.0;
        }
    }
}
