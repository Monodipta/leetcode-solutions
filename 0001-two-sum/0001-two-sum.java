import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> twoSum = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int compliment = target - nums[i];

            if (twoSum.containsKey(compliment)) {
                return new int[] { twoSum.get(compliment), i };
            }

            twoSum.put(nums[i], i);
        }

        return new int[] {};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna