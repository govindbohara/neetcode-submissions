class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        for(int i = 0; i< points.length;i++){
            minHeap.offer(points[i]);
        }
        for(int i = 0; i<k; i++){
            res[i] = minHeap.poll();
        }
        return res;
    }
}
