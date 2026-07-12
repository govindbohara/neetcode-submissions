class Solution {
    public void solve(char[][] board) {
        if(board.length == 0) return;
        Queue<int[]> queue = new LinkedList<>();

        int rows = board.length;
        int cols = board[0].length;
        for(int row= 0; row<rows;row++){
            if(board[row][0] =='O'){
                queue.offer(new int[]{row,0});
                board[row][0] ='T';
            }
            if(board[row][cols-1] == 'O'){
                queue.offer(new int[]{row,cols-1});
                board[row][cols-1] = 'T';
            }
        }
        for(int col = 0; col<cols;col++){
            if(board[0][col] == 'O'){
                queue.offer(new int[]{0,col});
                board[0][col] = 'T';
            }
            if(board[rows-1][col] == 'O'){
                queue.offer(new int[]{rows-1,col});
                board[rows-1][col] = 'T';
            }
        }
        int[][] dirs = {
            {0,-1},
            {0,1},
            {-1,0},
            {1,0}
        };
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir: dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                if(r <0|| c<0 || r>= board.length || c>= board[0].length){
                    continue;
                }
                if(board[r][c] != 'O'){
                    continue;
                }
                board[r][c] = 'T';
                queue.offer(new int[]{r,c});
            }

        }
        for(int row=0; row<rows; row++){
            for(int col=0;col<cols;col++){
                if(board[row][col] == 'O'){
                    board[row][col] = 'X';
                }else if(board[row][col] == 'T'){
                    board[row][col] = 'O';
                }
            }
        }
    }
}
