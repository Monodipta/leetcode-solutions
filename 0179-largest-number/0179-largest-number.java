import java.util.Collections;
class Solution {
    public String largestNumber(int[] nums) {
        String[] stringNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(stringNums, new Comparator<>(){

            @Override
            public int compare(String a, String b){
                String order1=a+b;
                String order2=b+a;

                return order2.compareTo(order1);
            }
        });

        if (stringNums[0].equals("0")) {
            return "0";
        }

        String largestNumber ="";
        for(String str : stringNums){
            largestNumber+=str;
        }

        return largestNumber;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna