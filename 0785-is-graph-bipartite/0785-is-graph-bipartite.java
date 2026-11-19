
class Solution {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];

        for (int i = 0; i < n; i++) {

            if (color[i] == 0) {

                if (!dfs(graph, i, 1, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int node,
                        int currentColor, int[] color) {

        color[node] = currentColor;

        for (int neighbor : graph[node]) {

            if (color[neighbor] == 0) {

                if (!dfs(graph, neighbor,
                         -currentColor, color)) {
                    return false;
                }
            }

            else if (color[neighbor] == currentColor) {
                return false;
            }
        }

        return true;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna