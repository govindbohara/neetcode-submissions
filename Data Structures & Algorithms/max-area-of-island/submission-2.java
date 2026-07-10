class Solution {
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int row= 0; row<grid.length;row++){
            for(int col= 0; col<grid[0].length;col++){
                if(grid[row][col] == 1){
                    maxArea = Math.max(checkArea(grid, row,col), maxArea);
                   
                }
            }
        }
        return maxArea;
        
    }

    public int checkArea(int[][] grid, int row , int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }
        int area = 0;
        grid[row][col] = 0;
        area += checkArea(grid, row-1, col);
        area += checkArea(grid, row+1, col);
        area += checkArea(grid, row, col-1);
        area += checkArea(grid, row, col+1);
        return area +1;
    }


}
