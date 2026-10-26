class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurance = firstOccurance(nums,target);

        if(firstOccurance == -1){
            return new int[]{-1,-1};
        }

        int lastOccurance = lastOccurance(nums,target);

        return new int[]{firstOccurance,lastOccurance};
    }

    public static int firstOccurance(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int answer = -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                answer = mid;
                right = mid - 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return answer;
    }

    public static int lastOccurance(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int answer = -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                answer = mid;
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
         return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna