class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> freq=new HashMap<>();

        for(Character ch : s.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        int i=0;
        for(Character ch: s.toCharArray()){
            if(freq.get(ch) == 1){
                return i;
            }
            i++;
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna