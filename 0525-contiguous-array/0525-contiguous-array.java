class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();

        map.put(0,-1);

        int prefixSum=0;
        int maxLength=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                prefixSum+=-1;
            }else{
                prefixSum+=1;
            }
            if(map.containsKey(prefixSum)){
                int previousIndex=map.get(prefixSum);
                int length=i-previousIndex;
                maxLength=Math.max(maxLength,length);
            }else{
                map.put(prefixSum,i);
            }
        }
        return maxLength;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna