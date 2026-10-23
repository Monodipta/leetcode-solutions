class Solution {
    public void sortColors(int[] nums) {
        
        for(int i=1;i<nums.length;i++){
            int key=nums[i];
            int j=i-1;

            while(j>=0 && nums[j] > key){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=key;
        }

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna