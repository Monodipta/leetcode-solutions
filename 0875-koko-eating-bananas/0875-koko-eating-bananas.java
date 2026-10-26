class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile : piles){
            right=Math.max(right,pile);
        }

        while(left<right){
            int mid=left+(right-left)/2;

            if(canFinish(piles,h,mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public static boolean canFinish(int[] piles,int h,int speed){
        long totalHours = 0;

        for(int pile : piles){
             totalHours += (pile + (long) speed - 1) / speed;

             if(totalHours > h){
                return false;
             }
        }
        return totalHours <= h;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna