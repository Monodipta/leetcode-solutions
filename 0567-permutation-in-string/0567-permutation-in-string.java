class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k=s1.length();

        if(k>s2.length()){
            return false;
        }

        int[] count1=new int[26];
        int[] count2=new int[26];

        for(int i=0;i<k;i++){
            count1[s1.charAt(i)-'a']++;
        }

        for(int i=0;i<k;i++){
            count2[s2.charAt(i)-'a']++;
        }

        if(Arrays.equals(count1,count2)){
            return true;
        }

        for(int i=k;i<s2.length();i++){
            count2[s2.charAt(i-k)-'a']--;

            count2[s2.charAt(i)-'a']++;

            if(Arrays.equals(count1,count2)){
                return true;
            }
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna