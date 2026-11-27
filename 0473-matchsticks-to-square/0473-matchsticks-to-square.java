class Solution {

    public boolean makesquare(int[] matchsticks) {

        int totalSum = 0;

        for (int stick : matchsticks) {
            totalSum += stick;
        }

        if (totalSum % 4 != 0) {
            return false;
        }

        int target = totalSum / 4;

        Arrays.sort(matchsticks);

        // Largest matchstick first
        int n = matchsticks.length;

        int[] sticks = new int[n];

        for (int i = 0; i < n; i++) {
            sticks[i] = matchsticks[n - 1 - i];
        }

        if (sticks[0] > target) {
            return false;
        }

        int[] sides = new int[4];

        return backtrack(sticks, 0, sides, target);
    }

    private boolean backtrack(
        int[] sticks,
        int index,
        int[] sides,
        int target
    ) {

        // All matchsticks have been placed
        if (index == sticks.length) {
            return true;
        }

        int currentStick = sticks[index];

        for (int i = 0; i < 4; i++) {

            if (sides[i] + currentStick <= target) {

                sides[i] += currentStick;

                if (backtrack(sticks, index + 1, sides, target)) {
                    return true;
                }

                // Backtrack
                sides[i] -= currentStick;
            }

            // Symmetry pruning:
            // No need to try another empty side
            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna