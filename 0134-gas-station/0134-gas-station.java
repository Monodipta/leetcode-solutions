class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0;
        int totalCost=0;

        int start=0;
        int currentTank=0;

        for(int i=0;i<gas.length;i++){
            int balance=gas[i]-cost[i];

            totalCost+=cost[i];
            totalGas+=gas[i];

            currentTank+=balance;

            if(currentTank<0){
                start=i+1;
                currentTank=0;
            }
        }
        return totalGas<totalCost?-1:start;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna