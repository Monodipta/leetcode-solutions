class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // Count task frequencies
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find maximum frequency
        int maxFreq = 0;

        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        // Count tasks having maximum frequency
        int countMax = 0;

        for (int count : freq) {
            if (count == maxFreq) {
                countMax++;
            }
        }

        int intervals = (maxFreq - 1) * (n + 1) + countMax;

        return Math.max(tasks.length, intervals);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna