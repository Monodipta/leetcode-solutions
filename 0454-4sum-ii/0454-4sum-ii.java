class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count=0;

        Map<Integer,Integer> mapAB = new HashMap<>();

        for(int a : nums1){
            for(int b : nums2){
                int sumAB = a + b;
                mapAB.put(sumAB, mapAB.getOrDefault(sumAB, 0) + 1);
            }
        }

        for(int c: nums3){
            for(int d: nums4){
                int sumCD= c+d;
                int target=-sumCD;

                if(mapAB.containsKey(target)){
                    count+=mapAB.get(target);
                }
            }
        }
        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna