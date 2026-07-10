class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int row= 0; row< grid.length; row++){
            char[] irow= grid[row];
            for(int col = 0; col<irow.length; col++ ){
                boolean isTrue;
                char indi = grid[row][col];
                if(indi == '1'){
                    count++;
                    checkIsland(grid, row,col);
                }
            }
        }

        return count;
        
    }
    public void checkIsland(char[][] grid, int row, int col){
        if(row <0 || row >= grid.length || col < 0 || col>= grid[0].length || grid[row][col] == '0'){
            return;
        }
        grid[row][col] = '0';
        checkIsland(grid,row,col-1);
        checkIsland(grid, row, col+1);
        checkIsland(grid,row-1,col);
        checkIsland(grid,row+1, col);

    }
}
