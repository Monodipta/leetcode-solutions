class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        int[] currentRunning = intervals[0];
        System.out.println(Arrays.toString(currentRunning));
        list.add(currentRunning);

        for(int i=1;i<intervals.length;i++){
            int[] nextInterval = intervals[i];

            if(currentRunning[1] >= nextInterval[0]){
                currentRunning[1] = Math.max(currentRunning[1], nextInterval[1]);
            }else{
                currentRunning=nextInterval;
                list.add(currentRunning);
            }
        }
        
         return list.toArray(new int[list.size()][]);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna