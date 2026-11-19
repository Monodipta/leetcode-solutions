class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    dfs(grid,i,j,2);
                }
            }
        }

        int minutes=2;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return -1;
                }
                minutes = Math.max(minutes, grid[i][j]);
            }
        }
        return minutes-2;
    }

    private void dfs(int[][] grid,int row,int col, int time){
        int m=grid.length;
        int n=grid[0].length;

        if(row<0||row>=m||col<0||col>=n){
            return;
        }

         if (grid[row][col] == 0 || (grid[row][col] > 1 && grid[row][col] < time)) {
            return;
        }

        grid[row][col]=time;

        dfs(grid,row-1,col,time+1);
        dfs(grid,row+1,col,time+1);
        dfs(grid,row,col-1,time+1);
        dfs(grid,row,col+1,time+1);

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna