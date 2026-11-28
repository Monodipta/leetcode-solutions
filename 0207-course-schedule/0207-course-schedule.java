class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre:prerequisites){
            int course=pre[0];
            int prerequisite=pre[1];
            graph.get(prerequisite).add(course);
        }

        int[] state=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(state[i]==0){
                if(hasCycle(i,graph,state)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasCycle(int course, List<List<Integer>> graph, int[] state) {
        // Mark as currently visiting in the active recursion path
        state[course] = 1;

        for (int nextCourse : graph.get(course)) {
            // If nextCourse is already in the current path, we found a cycle
            if (state[nextCourse] == 1) {
                return true;
            }
            // If unvisited, recursively check its neighbors
            if (state[nextCourse] == 0) {
                if (hasCycle(nextCourse, graph, state)) {
                    return true;
                }
            }
        }

        // Mark as completely visited and safe
        state[course] = 2;
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna