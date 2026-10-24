class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
      List<int[]> newIntervals = new ArrayList<>();

        // 2. Add your new interval
        list.add(newInterval);

        // 3. Sort the list by the first element (index 0) of each array
        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        int[] currentRunning = list.get(0);
        newIntervals.add(currentRunning);

        for(int i=1;i<list.size();i++){
            int[] nextInterval = list.get(i);

            if(nextInterval[0] <= currentRunning[1]){
                currentRunning[1] = Math.max(nextInterval[1],currentRunning[1]);
            }else{
                currentRunning = nextInterval;
                newIntervals.add(currentRunning);
            }
        }

        return newIntervals.toArray(new int[newIntervals.size()][]);
      
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna