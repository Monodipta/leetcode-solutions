class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 1. Keep your exact same start-time sorting
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int removals = 0;
        int prevEnd = intervals[0][1]; // Replaces currentRunning[1]
        
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            
            // 2. Strict '>' because touching endpoints (e.g. [1,2] and [2,3]) don't overlap
            if (prevEnd > nextInterval[0]) {
                removals++;
                // 3. Greedy choice: keep the interval that ends earlier (Math.min)
                prevEnd = Math.min(prevEnd, nextInterval[1]);
            } else {
                // 4. No overlap: move forward to the new interval's end
                prevEnd = nextInterval[1];
            }
        }
        
        return removals;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna