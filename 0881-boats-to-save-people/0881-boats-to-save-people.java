class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int n=people.length;

        int left=0;
        int right=n-1;

        int boats=0;

        while(left<=right){
            if(people[left]+people[right]<=limit){
                left++;
            }
            right--;
            boats++;
        }
        return boats;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna