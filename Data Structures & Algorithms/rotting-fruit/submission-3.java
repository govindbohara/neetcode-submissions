class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for(int row= 0;row<grid.length;row++){
            for(int col = 0; col< grid[0].length;col++){
                if(grid[row][col] == 2){
                    queue.offer(new int[]{row,col});
                }else if(grid[row][col] == 1){
                    fresh++;

                }

            }
        }
        int minTime =0;
        int[][] dirs = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };
        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for(int i = 0; i<size;i++){
                int[] curr = queue.poll();
                for(int[] dir:dirs){
                    int r = dir[0]+curr[0];
                    int c = dir[1]+ curr[1];
                    if(r<0 || c<0 || r>= grid.length || c>= grid[0].length){
                        continue;
                    }
                    if(grid[r][c] == 2 || grid[r][c] ==0){
                        continue;
                    }
                    if(grid[r][c] == 1){
                        grid[r][c] = 2;
                        fresh--;
                        queue.offer(new int[]{r,c});
                    }
                }

            }
            minTime++;

        }
        return fresh ==0 ?minTime :-1;
    }
    
}
