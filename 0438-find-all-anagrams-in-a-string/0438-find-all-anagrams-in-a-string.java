class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int k=p.length();

        if(k>s.length()){
            return result;
        }

        int[] pCount=new int[26];
        int[] windowSize=new int[26];

        for(int i=0;i<k;i++){
            pCount[p.charAt(i)-'a']++;
        }

        for(int i=0;i<k;i++){
            windowSize[s.charAt(i)-'a']++;
        }

        if(Arrays.equals(pCount,windowSize)){
            result.add(0);
        }

        for(int i=k;i<s.length();i++){
            windowSize[s.charAt(i-k)-'a']--;

            windowSize[s.charAt(i)-'a']++;

            if(Arrays.equals(pCount,windowSize)){
                result.add(i-k+1);
            }
        }
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna