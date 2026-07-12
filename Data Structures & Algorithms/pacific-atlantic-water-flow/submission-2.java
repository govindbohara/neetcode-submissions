class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        int rows = heights.length;
        int cols= heights[0].length;

        boolean[][] pacificVisited = new boolean[rows][cols];
        boolean[][] atlanticVisited = new boolean[rows][cols];

        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();

        for(int row = 0; row<rows; row++){
            pacificQ.offer(new int[]{row,0});
            pacificVisited[row][0] = true;
        }
        for(int col= 0; col<cols; col++){
            pacificQ.offer(new int[]{0,col});
            pacificVisited[0][col] = true;
        }
        for(int row = 0; row<rows;row++){
            atlanticQ.offer(new int[]{row,cols-1});
            atlanticVisited[row][cols-1] = true;
        }
        for(int col = 0; col<cols;col++){
            atlanticQ.offer(new int[]{rows-1,col});
            atlanticVisited[rows-1][col] = true;
        }

        int[][] dirs = {
            {0,1},
            {0,-1},
            {-1,0},
            {1,0}
        };
        bfs(pacificVisited, heights,dirs, pacificQ);
        bfs(atlanticVisited, heights, dirs, atlanticQ);

        for(int row= 0;row<rows;row++){
            for(int col= 0; col<cols;col++){
                if(pacificVisited[row][col] && atlanticVisited[row][col]){
                    res.add(Arrays.asList(row,col));
                }
            }
        }
        return res;

    }

    public void bfs(boolean[][] visited, int[][] heights, int[][] dirs, Queue<int[]> queue){
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for(int[] dir:dirs){
                int r = dir[0] + row;
                int c = dir[1] + col;

                if(r<0 || c<0 || r>= heights.length || c>= heights[0].length){
                    continue;
                }
                if(visited[r][c]){
                    continue;
                }

                if(heights[r][c] < heights[row][col]){
                    continue;
                }
                visited[r][c] = true;
                queue.offer(new int[]{r,c});
            }
        }

    }
}
