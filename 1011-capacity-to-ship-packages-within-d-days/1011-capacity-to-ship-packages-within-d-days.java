class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0; 
        int right = 0; 
        
        for (int weight : weights) { 
            left = Math.max(left, weight); 
            right += weight;              
        } 

        while(left < right){
            int mid = left + (right -left)/2;

            if(canShip(weights,days,mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public static boolean canShip(int[] weights,int days,int capacity){
        int usedDays=1;
        int currentLoad =0;

        for(int weight : weights){
            if(currentLoad+weight > capacity){
                usedDays++;
                currentLoad=weight;
            }else{
                currentLoad+=weight;
            }
        }
        return usedDays <= days;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna