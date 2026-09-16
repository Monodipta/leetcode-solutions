class Solution {
    public boolean isPalindrome(String s) {
        String cleanText = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        StringBuilder sb= new StringBuilder(cleanText);
        if(sb.length()==0){
            return true;
        }
        int start=0;
        int end=sb.length()-1;
        while(start<end){
            if(sb.charAt(start)!=sb.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna