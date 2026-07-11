class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int row= 0; row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col] == 0){
                    queue.offer(new int[]{row,col});
                }
            }
        }
        int[][] dirs = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        while(!queue.isEmpty()){
            int[]cell = queue.poll();
            int row = cell[0];
            int col= cell[1];
            for(int[] dir: dirs){
                int r = row+ dir[0];
                int c = col + dir[1];
                if(r <0 || c<0 || r>= grid.length || c>= grid[0].length){
                    continue;
                };
                if(grid[r][c] != Integer.MAX_VALUE){
                    continue;
                };
                grid[r][c] = grid[row][col]+1;
                queue.offer(new int[]{r,c});
            }
        }
        
    }
}
