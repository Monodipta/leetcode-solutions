class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int maxArea=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    int area=dfs(grid,i,j);

                    maxArea=Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid,int row,int col){
        int m=grid.length;
        int n=grid[0].length;

        if(row<0||row>=m||col<0||col>=n){
            return 0;
        }

        if(grid[row][col] == 0){
            return 0;
        }

        grid[row][col]=0;

        int area=1;

        area+=dfs(grid,row-1,col);
        area+=dfs(grid,row+1,col);
        area+=dfs(grid,row,col-1);
        area+=dfs(grid,row,col+1);

        return area;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna