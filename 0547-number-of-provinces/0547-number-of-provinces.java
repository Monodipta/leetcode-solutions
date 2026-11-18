class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;

        boolean[] isVisited=new boolean[n];

        int provinces=0;

        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                provinces++;
                dfs(i,isConnected,isVisited);
            }
        }
        return provinces;
    }

    private void dfs(int city,int[][] isConnected,boolean[] isVisited){
        isVisited[city]=true;

        for(int neighbour=0;neighbour<isConnected.length;neighbour++){
            if(isConnected[city][neighbour] == 1 && !isVisited[neighbour]){
                dfs(neighbour,isConnected,isVisited);
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna