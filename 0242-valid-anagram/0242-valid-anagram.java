import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> counts = new HashMap<>();

        // Count characters in string s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        // Subtract character counts using string t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!counts.containsKey(ch) || counts.get(ch) == 0) {
                return false;
            }
            counts.put(ch, counts.get(ch) - 1);
        }

        return true;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna