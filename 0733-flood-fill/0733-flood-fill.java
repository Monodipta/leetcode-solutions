class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        if(originalColor == color){
            return image;
        }

        dfs(image,sr,sc,originalColor,color);

        return image;
    }

    private void dfs(int[][] image,int row,int col,int originalColor,int newColor){
        int m=image.length;
        int n=image[0].length;

        if(row<0 || row>=m || col<0 || col>=n){
            return;
        }

        if(image[row][col] != originalColor){
            return;
        }

        image[row][col] = newColor;

        dfs(image,row-1,col,originalColor,newColor);
        dfs(image,row+1,col,originalColor,newColor);
        dfs(image,row,col-1,originalColor,newColor);
        dfs(image,row,col+1,originalColor,newColor);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna