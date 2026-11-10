class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
         if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] count=new int[26];

        for(char ch : magazine.toCharArray()){
            count[ch-'a']++;
        }

        for(char ch: ransomNote.toCharArray()){
            count[ch-'a']--;

            if(count[ch-'a'] < 0){
                return false;
            }

        }
        return true;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna